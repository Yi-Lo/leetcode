package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/14 18:27
 * @version 1.0
 * @topics String
 * @urllink https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class P557_Reverse_Words_in_a_String_III {

    public static String reverseWords(String s) {
        int l = 0;
        char[] chs = s.toCharArray();
        while (l < s.length()) {
            int r = l;
            while (r < chs.length && chs[r] != ' ') r++;
            reverseStr(chs, l, r - 1);
            l = r + 1;
        }
        return new String(chs);
    }

    public static void reverseStr(char[] chs, int l, int r) {
        while (l < r) {
            char tmp = chs[l];
            chs[l++] = chs[r];
            chs[r--] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
