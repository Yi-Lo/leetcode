package solution.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Yi-Lo
 * 2021/1/9 13:42
 * @version 1.0
 * @topics Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/word-break/
 */
public class P139_Word_Break {

    public static boolean wordBreak_s1(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        if (s.length() >= 151) return false;
        for (String word : wordDict) {
            if (s.startsWith(word) && wordBreak_s1(s.substring(word.length()), wordDict)) {
                return true;
            }
        }
        return false;
    }

    public static boolean wordBreak_s2(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && dictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static boolean wordBreak_s3(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1];
        return dfs(s, 0, wordDict, visited);
    }

    public static boolean dfs(String s, int curr, List<String> dict, boolean[] visited) {
        for (String word : dict) {
            int next = curr + word.length();
            if (next > s.length() || visited[next]) continue;
            if (s.indexOf(word, curr) == curr) {
                if (next == s.length() || dfs(s, next, dict, visited)) {
                    return true;
                }
                visited[next] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "cars";
        List<String> wordDict = Arrays.asList("car", "ca", "rs");
        System.out.println(wordBreak_s1(s, wordDict));
        System.out.println(wordBreak_s2(s, wordDict));
        System.out.println(wordBreak_s3(s, wordDict));
    }
}
