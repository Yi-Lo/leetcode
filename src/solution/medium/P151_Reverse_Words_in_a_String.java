package solution.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/12/14 18:21
 * @version 1.0
 * @topics String
 * @urllink https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class P151_Reverse_Words_in_a_String {

    public static String reverseWords_s1(String s) {
        s = s.trim();
        List<String> words = Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    public static String reverseWords_s2(String s) {
        char[] chs = s.trim().toCharArray();
        reverseStr(chs, 0, chs.length - 1);
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] != ' ') {
                int l = i;
                while (i < chs.length && chs[i] != ' ') i++;
                reverseStr(chs, l, i - 1);
            }
        }
        return new String(chs).replaceAll("\\s+", " ");
    }

    public static void reverseStr(char[] chs, int l, int r) {
        while (l < r) {
            char tmp = chs[l];
            chs[l++] = chs[r];
            chs[r--] = tmp;
        }
    }

    public static String reverseWords_s3(String s) {
        StringBuilder sb = new StringBuilder();
        buildReverseWords(s, sb, 0, false);
        return sb.toString();
    }

    public static void buildReverseWords(String str, StringBuilder sb, int start, boolean append) {
        while (start < str.length() && str.charAt(start) == ' ') start++;
        if (start == str.length()) return;
        int end = start;
        while (end < str.length() && str.charAt(end) != ' ') end++;
        buildReverseWords(str, sb, end, true);
        sb.append(str, start, end);
        if (append) sb.append(" ");
    }

    public static void main(String[] args) {
        System.out.println(reverseWords_s1("the sky is blue"));
        System.out.println(reverseWords_s2("  hello world  "));
        System.out.println(reverseWords_s3("a good   example"));
    }
}
