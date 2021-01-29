package solution.hard;

/**
 * @author Yi-Lo
 * 2021/1/28 20:53
 * @version 1.0
 * @topics Depth-first Search、Topological Sort、Memoization
 * @urllink https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 */
public class P329_Longest_Increasing_Path_in_a_Matrix {

    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length, ans = 0;
        if (matrix == null || row == 0 || col == 0) return 0;
        int[][] visit = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visit[i][j] == 0) {
                    ans = Math.max(ans, dfs(matrix, i, j, visit));
                }
            }
        }
        return ans;
    }

    public static int dfs(int[][] matrix, int x, int y, int[][] visit) {
        if (visit[x][y] != 0) return visit[x][y];
        visit[x][y]++;
        for (int[] dir : dirs) {
            int xx = x + dir[0], yy = y + dir[1];
            if (xx >= 0 && xx < matrix.length && yy >= 0 && yy < matrix[0].length && matrix[xx][yy] > matrix[x][y]) {
                visit[x][y] = Math.max(visit[x][y], dfs(matrix, xx, yy, visit) + 1);
            }
        }
        return visit[x][y];
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, {19, 18, 17, 16, 15, 14, 13, 12, 11, 10}, {20, 21, 22, 23, 24, 25, 26, 27, 28, 29}, {39, 38, 37, 36, 35, 34, 33, 32, 31, 30}, {40, 41, 42, 43, 44, 45, 46, 47, 48, 49}, {59, 58, 57, 56, 55, 54, 53, 52, 51, 50}, {60, 61, 62, 63, 64, 65, 66, 67, 68, 69}, {79, 78, 77, 76, 75, 74, 73, 72, 71, 70}, {80, 81, 82, 83, 84, 85, 86, 87, 88, 89}, {99, 98, 97, 96, 95, 94, 93, 92, 91, 90}, {100, 101, 102, 103, 104, 105, 106, 107, 108, 109}, {119, 118, 117, 116, 115, 114, 113, 112, 111, 110}, {120, 121, 122, 123, 124, 125, 126, 127, 128, 129}, {139, 138, 137, 136, 135, 134, 133, 132, 131, 130}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(longestIncreasingPath(matrix));
    }
}
