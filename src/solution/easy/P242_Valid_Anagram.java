package solution.easy;

import java.util.HashMap;

/**
 * @author Yi-Lo
 * 2020/10/25 20:40
 * @version 1.0
 * @topics Sort、Hash Table
 * @urllink https://leetcode-cn.com/problems/valid-anagram/
 */
public class P242_Valid_Anagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int key = ch - 'a';
            Integer count = map.get(key);
            if (count == null) {
                count = 0;
            }
            map.put(key, ++count);
        }
        for (char ch : t.toCharArray()) {
            int key = ch - 'a';
            Integer count = map.get(key);
            if (count == null) {
                return false;
            }
            map.put(key, --count);
        }
        for (Integer val : map.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram_s1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram_s1(s, t));
    }
}
