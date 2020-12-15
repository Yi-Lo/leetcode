package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/15 18:05
 * @version 1.0
 * @topics String
 * @urllink https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class P680_Valid_Palindrome_II {

    public static boolean validPalindrome(String s) {
        char[] chs = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (chs[l] == chs[r]) {
                l++;
                r--;
            } else {
                return isPalindrome(chs, l + 1, r) || isPalindrome(chs, l, r - 1);
            }
        }
        return true;
    }

    public static boolean isPalindrome(char[] chs, int l, int r) {
        while (l < r) {
            if (chs[l++] != chs[r--]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
    }
}
