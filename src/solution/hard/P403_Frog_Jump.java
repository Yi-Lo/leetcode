package solution.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yi-Lo
 * 2020/11/26 21:30
 * @version 1.0
 * @topics Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/frog-jump/
 */
public class P403_Frog_Jump {

    public static boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }

    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(canCross(stones));
    }
}
