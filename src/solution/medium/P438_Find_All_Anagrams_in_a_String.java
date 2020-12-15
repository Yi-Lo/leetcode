package solution.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/12/15 17:58
 * @version 1.0
 * @topics Hash Table
 * @urllink https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class P438_Find_All_Anagrams_in_a_String {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] needs = new int[26], windows = new int[26];
        char[] chs = s.toCharArray(), chp = p.toCharArray();
        for (char ch : chp) needs[ch - 'a']++;
        int head = 0, tail = 0;
        while (tail < chs.length) {
            int curr = chs[tail++] - 'a';
            windows[curr]++;
            while (windows[curr] > needs[curr]) {
                windows[chs[head++] - 'a']--;
            }
            if (tail - head == chp.length) {
                list.add(head);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
