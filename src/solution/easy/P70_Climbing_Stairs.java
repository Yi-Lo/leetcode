package solution.easy;

/**
 * @author Yi-Lo
 * 2020/10/27 19:21
 * @version 1.0
 * @topics Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/climbing-stairs/
 */
public class P70_Climbing_Stairs {

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs_s1(int n) {
        int p = 0, q = 1, ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = p + q;
            p = q;
            q = ans;
        }
        return ans;
    }
}
