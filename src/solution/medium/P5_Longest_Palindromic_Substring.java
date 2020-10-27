package solution.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Yi-Lo
 * 2020/10/17 17:16
 * @version 1.0
 * @topics String、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class P5_Longest_Palindromic_Substring {

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        HashSet<String> set = new HashSet<>();
        String[] arr = s.split("");
        for (String ss : arr) {
            set.add(ss);
        }
        if (set.size() == 1) {
            return s;
        }
        if (len == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            }
            return s.substring(0, 1);
        }
        int maxlen = 0;
        HashMap<Integer, String> resMap = new HashMap<>();
        for (int i = 1; i < len - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            if (s.charAt(left) == s.charAt(i)) {
                left--;
            }
            if (s.charAt(i) == s.charAt(right)) {
                right++;
            }
            boolean find = false;
            while (left > -1 && right < len && (s.charAt(left) == s.charAt(right))) {
                find = true;
                left--;
                right++;
            }
            if (find) {
                left++;
                right--;
            }
            int sublen = right - left + 1;
            if (find && sublen > maxlen) {
                resMap.put(sublen, s.substring(left, right + 1));
                maxlen = sublen;
            }
        }
        return resMap.isEmpty() ? s.substring(0, 1) : resMap.get(maxlen);
    }

    public static void main(String[] args) {
        String str = "cbbba";
        String res = longestPalindrome(str);
        System.out.println(res);
    }
}
