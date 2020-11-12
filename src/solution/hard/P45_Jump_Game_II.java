package solution.hard;

/**
 * @author Yi-Lo
 * 2020/11/11 17:31
 * @version 1.0
 * @topics Greedy、Array
 * @urllink https://leetcode-cn.com/problems/jump-game-ii/
 */
public class P45_Jump_Game_II {

    public static int jump_s1(int[] nums) {
        int steps = 0;
        int pos = nums.length - 1;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (i + nums[i] >= pos) {
                    pos = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public static int jump_s2(int[] nums) {
        int steps = 0, maxPos = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(jump_s2(new int[]{1, 2, 3}));
        System.out.println(jump_s2(new int[]{3, 2, 1}));
        System.out.println(jump_s2(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump_s2(new int[]{2, 3, 0, 1, 4}));
    }
}
