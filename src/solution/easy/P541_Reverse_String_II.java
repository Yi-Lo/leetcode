package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/13 18:14
 * @version 1.0
 * @topics String
 * @urllink https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class P541_Reverse_String_II {

    public static String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) return s;
        char[] chs = s.toCharArray();
        int kk = k * 2;
        int m = s.length() / kk;
        for (int i = 0; i <= m; i++) {
            int start = i * kk;
            int end = start + k - 1;
            end = Math.min(end, s.length() - 1);
            while (start < end) {
                char temp = chs[start];
                chs[start++] = chs[end];
                chs[end--] = temp;
            }
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }
}
