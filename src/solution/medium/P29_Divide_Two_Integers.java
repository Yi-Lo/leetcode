package solution.medium;

/**
 * @author Yi-Lo
 * 2021/1/22 21:50
 * @version 1.0
 * @topics Math、Binary Search
 * @urllink https://leetcode-cn.com/problems/divide-two-integers/
 */
public class P29_Divide_Two_Integers {

    public static int divide_s1(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        while (dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while (dividend <= (temp_divisor << 1)) {
                if (temp_divisor <= (Integer.MIN_VALUE >> 1)) break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if (!sign) {
            if (result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = -result;
        }
        return result;
    }

    public static int divide_s2(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative = (dividend ^ divisor) < 0;
        long temp_dividend = Math.abs((long) dividend);
        long temp_divisor = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((temp_dividend >> i) >= temp_divisor) {
                result += 1 << i;
                temp_dividend -= temp_divisor << i;
            }
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(divide_s1(10, 3));
        System.out.println(divide_s2(10, 3));
    }
}
