package solution.medium;

import java.util.Arrays;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/2/7 20:11
 * @version 1.0
 * @topics Sort、Two Pointers
 * @urllink https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 */
public class P524_Longest_Word_in_Dictionary_through_Deleting {

    public static String findLongestWord(String s, List<String> d) {
        String max_str = "";
        for (String t : d) {
            if (isSubsequence(t, s)) {
                if (max_str.length() < t.length() || (max_str.length() == t.length() && max_str.compareTo(t) > 0)) {
                    max_str = t;
                }
            }
        }
        return max_str;
    }

    public static boolean isSubsequence(String t, String s) {
        int index = -1;
        for (char ch : t.toCharArray()) {
            index = s.indexOf(ch, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(findLongestWord("abpcplea", d));
    }
}
