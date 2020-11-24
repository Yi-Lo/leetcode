package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/24 18:27
 * @version 1.0
 * @topics String、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/decode-ways/
 */
public class P91_Decode_Ways {

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            int singleNum = Integer.valueOf(s.substring(i - 1, i));
            int doubleNum = Integer.valueOf(s.substring(i - 2, i));
            if (0 < singleNum && singleNum < 10) {
                dp[i] += dp[i - 1];
            }
            if (9 < doubleNum && doubleNum < 27) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
