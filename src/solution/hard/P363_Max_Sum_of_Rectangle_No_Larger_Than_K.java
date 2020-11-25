package solution.hard;

import java.util.TreeSet;

/**
 * @author Yi-Lo
 * 2020/11/25 18:07
 * @version 1.0
 * @topics Queue、Binary Search、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class P363_Max_Sum_of_Rectangle_No_Larger_Than_K {

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) return 0;
        int rows = matrix.length, columns = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for (int left = 0; left < columns; left++) {
            int[] sums = new int[rows];
            for (int right = left; right < columns; right++) {
                for (int row = 0; row < rows; row++) {
                    sums[row] += matrix[row][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int curSum = 0;
                for (int sum : sums) {
                    curSum += sum;
                    Integer num = set.ceiling(curSum - k);
                    if (num != null) result = Math.max(result, curSum - num);
                    set.add(curSum);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1}, {0, -2, 3}};
        System.out.println(maxSumSubmatrix(matrix, 2));
    }
}
