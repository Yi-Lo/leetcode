package solution.medium;

import java.util.PriorityQueue;

/**
 * @author Yi-Lo
 * 2021/1/24 18:08
 * @version 1.0
 * @topics Heap、Binary Search
 * @urllink https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class P378_Kth_Smallest_Element_in_a_Sorted_Matrix {

    public static int kthSmallest_s1(int[][] matrix, int k) {
        int n = matrix.length, ans = matrix[0][0];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queue.offer(matrix[i][j]);
            }
        }
        for (int i = 0; i < k; i++) {
            ans = queue.poll();
        }
        return ans;
    }

    public static int kthSmallest_s2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1, j = 0, num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(kthSmallest_s1(matrix, 8));
        System.out.println(kthSmallest_s2(matrix, 8));
    }
}
