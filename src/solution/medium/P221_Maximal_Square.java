package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/25 18:05
 * @version 1.0
 * @topics Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/maximal-square/
 */
public class P221_Maximal_Square {

    public static int maximalSquare_s1(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return maxSide;
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);
                    int currentMaxLen = Math.min(rows - i, columns - j);
                    for (int m = 1; m < currentMaxLen; m++) {
                        boolean exit = false;
                        if (matrix[i + m][j + m] == '0') {
                            break;
                        }
                        for (int n = 0; n < m; n++) {
                            if (matrix[i + m][j + n] == '0' || matrix[i + n][j + m] == '0') {
                                exit = true;
                                break;
                            }
                        }
                        if (exit) {
                            break;
                        } else {
                            maxSide = Math.max(maxSide, m + 1);
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;
    }

    public static int maximalSquare_s2(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return maxSide;
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare_s2(matrix));
    }
}
