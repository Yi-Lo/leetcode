package solution.medium;

/**
 * @author Yi-Lo
 * 2020/10/17 17:16
 * @version 1.0
 * @topics String、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class P5_Longest_Palindromic_Substring {

    public static String longestPalindrome_s1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String longestPalindrome_s2(String s) {
        String str = "";
        int n = s.length();
        char[] chs = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = chs[i] == chs[j] && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > str.length()) {
                    str = s.substring(i, j + 1);
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome_s1("cbbba"));
        System.out.println(longestPalindrome_s2("cbbba"));
    }
}
