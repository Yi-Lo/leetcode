package solution.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/1/18 13:03
 * @version 1.0
 * @topics Array
 * @urllink https://leetcode-cn.com/problems/spiral-matrix/
 */
public class P54_Spiral_Matrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{6, 9, 7}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix4 = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};
        System.out.println(spiralOrder(matrix1));
        System.out.println(spiralOrder(matrix2));
        System.out.println(spiralOrder(matrix3));
        System.out.println(spiralOrder(matrix4));
    }
}
