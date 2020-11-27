package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/27 18:43
 * @version 1.0
 * @topics String、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class P647_Palindromic_Substrings {

    public static int countSubstrings(String s) {
        int len = s.length();
        if (len <= 1) return len;
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += palindromic(s, i, i);
            count += palindromic(s, i, i + 1);
        }
        return count;
    }

    public static int palindromic(String str, int left, int right) {
        int res = 0;
        while (0 <= left && right < str.length() && str.charAt(left) == str.charAt(right)) {
            res++;
            left--;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings("abc"));
    }

}
