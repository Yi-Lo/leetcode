package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/15 18:02
 * @version 1.0
 * @topics Two Pointers、String
 * @urllink https://leetcode-cn.com/problems/valid-palindrome/
 */
public class P125_Valid_Palindrome {

    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] chs = s.toLowerCase().toCharArray();
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(chs[l])) l++;
            while (l < r && !Character.isLetterOrDigit(chs[r])) r--;
            if (l < r && chs[l++] != chs[r--]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(".a"));
        System.out.println(isPalindrome(".,"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
