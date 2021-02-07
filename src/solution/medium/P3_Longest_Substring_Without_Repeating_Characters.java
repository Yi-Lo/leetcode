package solution.medium;

/**
 * @author Yi-Lo
 * 2021/2/7 19:53
 * @version 1.0
 * @topics Hash Table、Two Pointers、String、Sliding Window
 * @urllink https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class P3_Longest_Substring_Without_Repeating_Characters {

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int[] table = new int[256];
        int max_len = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            table[s.charAt(right)]++;
            while (table[s.charAt(right)] > 1) {
                table[s.charAt(left++)]--;
            }
            max_len = Math.max(max_len, right - left + 1);
        }
        return max_len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}