package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/14 18:29
 * @version 1.0
 * @topics String
 * @urllink https://leetcode-cn.com/problems/reverse-only-letters/
 */
public class P917_Reverse_Only_Letters {

    public static String reverseOnlyLetters(String S) {
        char[] chs = S.toCharArray();
        int l = 0, r = chs.length - 1;
        while (l < r) {
            while (l < r && !Character.isLetter(chs[l])) l++;
            while (r > l && !Character.isLetter(chs[r])) r--;
            char tmp = chs[l];
            chs[l++] = chs[r];
            chs[r--] = tmp;
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("7_28]"));
        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("?6C40E"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
