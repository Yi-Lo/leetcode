package solution.hard;

/**
 * @author Yi-Lo
 * 2020/12/16 17:58
 * @version 1.0
 * @topics Greedy、String、Dynamic Programming、Backtracking
 * @urllink https://leetcode-cn.com/problems/wildcard-matching/
 */
public class P44_Wildcard_Matching {

    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (chp[i - 1] == '*') dp[0][i] = true;
            else break;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (chp[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (chp[j - 1] == '?' || chs[i - 1] == chp[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("adceb", "*a*b"));
        System.out.println(isMatch("acdcb", "a*c?b"));
    }
}
