package solution.easy;

/**
 * @author Yi-Lo
 * 2020/11/12 20:14
 * @version 1.0
 * @topics Math、Binary Search
 * @urllink https://leetcode-cn.com/problems/sqrtx/
 */
public class P69_Sqrtx {

    public static int mySqrt_s1(int x) {
        if (x <= 1) return x;
        int left = 1, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }

    // Newton's method
    public static int mySqrt_s2(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }


    public static int mySqrt_s3(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt_s1(3));
    }
}
