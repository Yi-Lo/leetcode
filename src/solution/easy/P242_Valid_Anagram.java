package solution.easy;

import java.util.HashMap;

/**
 * @author Yi-Lo
 * 2020/10/25 20:40
 * @version 1.0
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

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
