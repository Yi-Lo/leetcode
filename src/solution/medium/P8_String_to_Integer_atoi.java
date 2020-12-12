package solution.medium;

/**
 * @author Yi-Lo
 * 2020/12/12 17:34
 * @version 1.0
 * @topics Math、String
 * @urllink https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class P8_String_to_Integer_atoi {

    public static int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;
        // test empty
        if (s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        // skip space
        while (index < s.length() && chs[index] == ' ') index++;
        // beyond length of s
        if (index >= s.length()) return 0;
        // deal sign
        if (chs[index] == '+' || chs[index] == '-') {
            sign = chs[index] == '+' ? 1 : -1;
            index++;
        }
        // convert and calculate
        while (index < s.length()) {
            int num = chs[index] - '0';
            if (num < 0 || num > 9) break;
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < num) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + num;
            index++;
        }
        return total * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(" "));
        System.out.println(myAtoi("+-12"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("4193 with words"));
    }
}
