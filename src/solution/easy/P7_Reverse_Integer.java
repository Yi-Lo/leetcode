package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/30 22:01
 * @version 1.0
 * @topics Math
 * @urllink https://leetcode-cn.com/problems/reverse-integer/
 */
public class P7_Reverse_Integer {

    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
    }
}
