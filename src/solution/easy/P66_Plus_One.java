package solution.easy;

/**
 * @author Yi-Lo
 * 2020/10/22 16:58
 * @version 1.0
 * @urllink https://leetcode-cn.com/problems/plus-one/
 */
public class P66_Plus_One {

    public static int[] plusOne(int[] digits) {
        int power = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + 1;
            if (sum > 9) {
                power = 1;
                digits[i] = 0;
            } else {
                digits[i] = sum;
                power = 0;
            }
            if (power == 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = power;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9};
        digits = plusOne(digits);
        for (int digit : digits) {
            System.out.println(digit);
        }
    }
}
