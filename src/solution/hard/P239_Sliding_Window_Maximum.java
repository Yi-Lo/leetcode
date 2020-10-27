package solution.hard;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Yi-Lo
 * 2020/10/23 17:40
 * @version 1.0
 * @topics Heap、Sliding Window
 * @urllink https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class P239_Sliding_Window_Maximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = 0; j < k; j++) {
                max = max >= nums[i + j] ? max : nums[i + j];
            }
            lst.add(max);
        }
        int[] ans = lst.stream().mapToInt(i -> i).toArray();
        return ans;
    }

    public static int[] maxSlidingWindow_s1(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - k) {
                qmax.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1};
//        int[] nums = {1, -1};
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        nums = maxSlidingWindow_s1(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
