package solution.easy;

/**
 * @author Yi-Lo
 * 2021/1/18 13:05
 * @version 1.0
 * @topics Hash Table、Math
 * @urllink https://leetcode-cn.com/problems/happy-number/
 */
public class P202_Happy_Number {

    public static boolean isHappy_s1(int n) {
        if (n == 1) return true;
        if (n < 7) return false;
        return isHappy_s1(next(n));
    }

    public static boolean isHappy_s2(int n) {
        int slow = n, fast = n;
        do {
            slow = next(slow);
            fast = next(fast);
            fast = next(fast);
        } while (slow != fast);
        return slow == 1;
    }

    public static int next(int n) {
        int sum = 0;
        while (n > 0) {
            int x = n % 10;
            sum += x * x;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy_s1(20));
        System.out.println(isHappy_s2(20));
    }
}
