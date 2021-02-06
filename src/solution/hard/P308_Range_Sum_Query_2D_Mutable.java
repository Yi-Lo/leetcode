package solution.hard;

import design.NumMatrix;

/**
 * @author Yi-Lo
 * 2021/2/6 21:22
 * @version 1.0
 * @topics Binary Indexed Tree、Segment Tree
 * @urllink https://leetcode-cn.com/problems/range-sum-query-2d-mutable/
 */
public class P308_Range_Sum_Query_2D_Mutable {

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        numMatrix.update(3, 2, 2);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }
}
