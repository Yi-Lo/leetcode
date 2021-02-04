package solution.medium;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author Yi-Lo
 * 2021/2/4 10:04
 * @version 1.0
 * @topics Hash Table、Two Pointers、String、Sliding Window
 * @urllink https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters/
 */
public class P340_Longest_Substring_with_At_Most_K_Distinct_Characters {

    public static int lengthOfLongestSubstringKDistinct_s1(String s, int k) {
        if (s.length() * k == 0) return 0;
        int left = 0, right = 0, max_len = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            map.put(s.charAt(right), right++);
            if (map.size() == k + 1) {
                int delete = Collections.min(map.values());
                map.remove(s.charAt(delete));
                left = delete + 1;
            }
            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }

    public static int lengthOfLongestSubstringKDistinct_s2(String s, int k) {
        int[] table = new int[256];
        int max_len = 0, right = 0, unique = 0;
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && unique <= k) {
                table[s.charAt(right)]++;
                if (table[s.charAt(right)] == 1) {
                    unique++;
                }
                if (unique <= k) {
                    max_len = Math.max(max_len, right - left + 1);
                }
                right++;
            }
            table[s.charAt(left)]--;
            if (table[s.charAt(left)] == 0) {
                unique--;
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct_s1("eceba", 2));
        System.out.println(lengthOfLongestSubstringKDistinct_s2("eceba", 2));
    }
}
