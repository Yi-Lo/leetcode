package solution.easy;

/**
 * @author Yi-Lo
 * 2021/1/30 10:10
 * @version 1.0
 * @topics Math
 * @urllink https://leetcode-cn.com/problems/power-of-three/
 */
public class P326_Power_of_Three {

    public static boolean isPowerOfThree_s1(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static boolean isPowerOfThree_s2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static boolean isPowerOfThree_s3(int n) {
        return Math.log10(n) / Math.log10(3) % 1 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree_s1(28));
        System.out.println(isPowerOfThree_s2(28));
        System.out.println(isPowerOfThree_s3(28));
    }
}
