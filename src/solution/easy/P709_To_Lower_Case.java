package solution.easy;

/**
 * @author Yi-Lo
 * 2020/11/15 21:13
 * @version 1.0
 * @topics String
 * @urllink https://leetcode-cn.com/problems/to-lower-case/
 */
public class P709_To_Lower_Case {

    public static String toLowerCase(String str) {
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if ('A' <= chs[i] && chs[i] <= 'Z') {
                chs[i] += 32;
            }
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(toLowerCase(s));
    }
}
