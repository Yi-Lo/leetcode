package solution.easy;

import java.math.BigInteger;

/**
 * @author Yi-Lo
 * 2021/1/25 16:16
 * @version 1.0
 * @topics Math
 * @urllink https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
public class P172_Factorial_Trailing_Zeroes {

    public static int trailingZeroes_s1(int n) {
        BigInteger nFactorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }
        int zeroCount = 0;
        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            nFactorial = nFactorial.divide(BigInteger.TEN);
            zeroCount++;
        }
        return zeroCount;
    }

    public static int trailingZeroes_s2(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static int trailingZeroes_s3(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes_s3(n / 5);
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes_s1(7));
        System.out.println(trailingZeroes_s2(7));
        System.out.println(trailingZeroes_s3(7));
    }
}
