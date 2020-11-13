package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/13 19:35
 * @version 1.0
 * @topics Array、Binary Search
 * @urllink https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class P74_Search_a_2D_Matrix {

    public static boolean searchMatrix_s1(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = matrix[mid / n][mid % n];
            if (val == target) {
                return true;
            } else if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean searchMatrix_s2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        for (int i = m - 1, j = 0; i >= 0 && j < n; ) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) j++;
            else i--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix_s2(matrix, 3));
    }
}
