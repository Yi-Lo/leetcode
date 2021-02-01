package solution.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yi-Lo
 * 2021/2/1 10:35
 * @version 1.0
 * @topics Hash Table、Math
 * @urllink https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 */
public class P166_Fraction_to_Recurring_Decimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder fraction = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) fraction.append("-");
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(dividend / divisor);
        long remainder = dividend % divisor;
        if (remainder == 0) return fraction.toString();
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(remainder / divisor);
            remainder %= divisor;
        }
        return fraction.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 333));
        System.out.println(fractionToDecimal(1, 90));
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(1, 6));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal(4, 333));
        System.out.println(fractionToDecimal(1, 5));
    }
}
