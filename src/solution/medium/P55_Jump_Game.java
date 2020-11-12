package solution.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/11/11 17:35
 * @version 1.0
 * @topics Greedy、Array
 * @urllink https://leetcode-cn.com/problems/jump-game/
 */
public class P55_Jump_Game {

    public static boolean canJump_s1(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros.add(i);
        }
        if (zeros.size() > 0) {
            for (int j = 0; j < zeros.size(); j++) {
                int step = 0;
                boolean jump = false;
                for (int k = zeros.get(j) - 1; k >= 0; k--) {
                    step++;
                    if ((nums[k] > step) || (nums[k] == step && zeros.get(j) == nums.length - 1)) {
                        jump = true;
                        break;
                    }
                }
                if (!jump) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean canJump_s2(int[] nums) {
        int rightmost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > rightmost) return false;
            rightmost = Math.max(rightmost, i + nums[i]);
        }
        return true;
    }

    public static boolean canJump_s3(int[] nums) {
        if (nums == null) return false;
        int rightmost = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i++) {
            if (nums[i] + i >= rightmost) {
                rightmost = i;
            }
        }
        return rightmost == 0;
    }

    public static void main(String[] args) {
        System.out.println(canJump_s1(new int[]{2, 0, 0}));
        System.out.println(canJump_s1(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump_s1(new int[]{3, 2, 1, 0, 4}));
    }
}
