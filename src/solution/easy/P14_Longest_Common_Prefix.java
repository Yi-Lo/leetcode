package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/13 18:08
 * @version 1.0
 * @topics String
 * @urllink https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class P14_Longest_Common_Prefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int count = strs.length;
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
