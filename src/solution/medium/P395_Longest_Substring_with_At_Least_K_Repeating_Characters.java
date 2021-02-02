package solution.medium;

import java.util.ArrayList;

/**
 * @author Yi-Lo
 * 2021/2/2 10:05
 * @version 1.0
 * @topics Recursion、Divide and Conquer、Sliding Window
 * @urllink https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class P395_Longest_Substring_with_At_Least_K_Repeating_Characters {

    public static int longestSubstring(String s, int k) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        ArrayList<Integer> split = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                split.add(i);
            }
        }
        if (split.isEmpty()) return s.length();
        int ans = 0, pre = 0;
        split.add(s.length());
        for (int end : split) {
            ans = end > pre ? Math.max(ans, longestSubstring(s.substring(pre, end), k)) : ans;
            pre = end + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("bbaaacbd", 3));
        System.out.println(longestSubstring("aabcabb", 3));
        System.out.println(longestSubstring("ababacb", 3));
        System.out.println(longestSubstring("weitong", 2));
        System.out.println(longestSubstring("aaabbb", 3));
        System.out.println(longestSubstring("aaabb", 3));
        System.out.println(longestSubstring("ababbc", 2));
    }
}
