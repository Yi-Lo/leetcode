package solution.easy;

/**
 * @author Yi-Lo
 * 2020/11/12 20:16
 * @version 1.0
 * @topics Math、Binary Search
 * @urllink https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class P367_Valid_Perfect_Square {

    public static boolean isPerfectSquare_s1(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid < num / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean isPerfectSquare_s2(int num) {
        long r = num;
        while (r * r > num) {
            r = (r + num / r) / 2;
        }
        return r * r == num;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare_s1(5));
    }
}
