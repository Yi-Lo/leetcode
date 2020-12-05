package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/5 18:06
 * @version 1.0
 * @topics Bit Manipulation、Math
 * @urllink https://leetcode-cn.com/problems/power-of-two/
 */
public class P231_Power_of_Two {

    public static boolean isPowerOfTwo_s1(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    public static boolean isPowerOfTwo_s2(int n) {
        if (n <= 0) return false;
        return (n & (-n)) == n;
    }
}
