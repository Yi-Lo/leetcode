package solution.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yi-Lo
 * 2021/1/26 16:04
 * @version 1.0
 * @topics Hash Table、Binary Search
 * @urllink https://leetcode-cn.com/problems/4sum-ii/
 */
public class P454_4Sum_II {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                Integer num = map.getOrDefault(sum, 0) + 1;
                map.put(a + b, num);
            }
        }
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                int target = -(c + d);
                if (map.containsKey(target)) {
                    count += map.get(target);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2}, B = {-2, -1};
        int[] C = {-1, 2}, D = {0, 2};
        System.out.println(fourSumCount(A, B, C, D));
    }
}
