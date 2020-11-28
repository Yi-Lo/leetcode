package solution.hard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Yi-Lo
 * 2020/11/28 18:48
 * @version 1.0
 * @topics Hash Table、Two Pointers、String、Sliding Window
 * @urllink https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class P76_Minimum_Window_Substring {

    private static Map<Character, Integer> ori = new HashMap<>();

    private static Map<Character, Integer> cnt = new HashMap<>();

    public static String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char ch = t.charAt(i);
            ori.put(ch, ori.getOrDefault(ch, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            r++;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public static boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
