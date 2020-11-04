package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/3 15:39
 * @version 1.0
 * @topics Math、Binary Search
 * @urllink https://leetcode-cn.com/problems/powx-n/
 */
public class P50_Pow_x_n {

    public static double myPow_s1(double x, int n) {
        if (x == 1.0) {
            return x;
        }
        if (n >= 0) {
            return fastPow(x, n);
        } else {
            return 1 / fastPow(x, -n);
        }
    }

    public static double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            half = half * half;
        } else {
            half = half * half * x;
        }
        return half;
    }

    public static double myPow_s2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / x * myPow_s1(1 / x, -n - 1);
        }
        return (n % 2 == 0) ? myPow_s1(x * x, n / 2) : x * myPow_s1(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(myPow_s1(2, -2));
        System.out.println(myPow_s2(2, -2147483648));
    }
}
