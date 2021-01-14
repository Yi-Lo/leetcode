package solution.medium;

/**
 * @author Yi-Lo
 * 2021/1/14 14:51
 * @version 1.0
 * @topics Binary Search、Divide and Conquer
 * @urllink https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class P240_Search_a_2D_Matrix_II {

    public static boolean searchMatrix_s1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix_s2(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int[] nums = matrix[i];
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix_s3(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row <= m - 1 && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix_s1(matrix, 5));
        System.out.println(searchMatrix_s2(matrix, 5));
        System.out.println(searchMatrix_s3(matrix, 5));
    }
}
