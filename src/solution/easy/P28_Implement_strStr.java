package solution.easy;

/**
 * @author Yi-Lo
 * 2021/1/16 13:29
 * @version 1.0
 * @topics Two Pointers、String
 * @urllink https://leetcode-cn.com/problems/implement-strstr/
 */
public class P28_Implement_strStr {

    public static int strStr(String haystack, String needle) {
        int h = haystack.length(), n = needle.length();
        for (int i = 0; i < h - n + 1; i++) {
            String str = haystack.substring(i, i + n);
            if (str.equals(needle)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("abc", "c"));
        System.out.println(strStr("hello", "ll"));
    }
}
