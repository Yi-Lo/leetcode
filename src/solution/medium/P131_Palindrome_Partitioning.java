package solution.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/1/26 16:03
 * @version 1.0
 * @topics Depth-first Search、Dynamic Programming、Backtracking
 * @urllink https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class P131_Palindrome_Partitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.isEmpty()) return result;
        List<String> visit = new ArrayList<>();
        backtrack(s.toCharArray(), 0, result, visit);
        return result;
    }

    public static void backtrack(char[] chs, int start, List<List<String>> result, List<String> visit) {
        if (chs.length == start) {
            result.add(new ArrayList<>(visit));
            return;
        }
        for (int i = start; i < chs.length; i++) {
            if (isPalindrome(chs, start, i)) {
                visit.add(new String(chs, start, i + 1 - start));
                backtrack(chs, i + 1, result, visit);
                visit.remove(visit.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(char[] chs, int start, int end) {
        if (start == end) return true;
        while (start < end) {
            if (chs[start++] != chs[end--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aabb"));
    }
}
