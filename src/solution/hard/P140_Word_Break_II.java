package solution.hard;

import java.util.*;

/**
 * @author Yi-Lo
 * 2021/1/30 10:20
 * @version 1.0
 * @topics Dynamic Programming、Backtracking
 * @urllink https://leetcode-cn.com/problems/word-break-ii/
 */
public class P140_Word_Break_II {

    public static List<String> wordBreak_s1(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1];
        List<String> result = new LinkedList<>();
        List<String> words = new LinkedList<>();
        backtrack(s, 0, wordDict, result, words, visited);
        return result;
    }

    public static void backtrack(String s, int curr, List<String> dict, List<String> result, List<String> words, boolean[] visited) {
        if (curr == s.length()) {
            result.add(String.join(" ", words));
            return;
        }
        for (String word : dict) {
            int next = curr + word.length();
            if (next > s.length() || visited[next]) continue;
            if (s.indexOf(word, curr) == curr) {
                words.add(word);
                visited[next] = true;
                backtrack(s, next, dict, result, words, visited);
                visited[next] = false;
                words.remove(words.size() - 1);
            }
        }
    }

    public static List<String> wordBreak_s2(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> wordGroup = backtrack(s, new HashSet<>(wordDict), 0, map);
        for (List<String> wordList : wordGroup) {
            result.add(String.join(" ", wordList));
        }
        return result;
    }

    public static List<List<String>> backtrack(String s, Set<String> dict, int start, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(start)) {
            List<List<String>> wordGroup = new LinkedList<>();
            if (start == s.length()) wordGroup.add(new LinkedList<>());
            for (int end = start + 1; end <= s.length(); end++) {
                String word = s.substring(start, end);
                if (dict.contains(word)) {
                    List<List<String>> childWordGroup = backtrack(s, dict, end, map);
                    for (List<String> childWordList : childWordGroup) {
                        LinkedList<String> wordList = new LinkedList<>(childWordList);
                        wordList.addFirst(word);
                        wordGroup.add(wordList);
                    }
                }
            }
            map.put(start, wordGroup);
        }
        return map.get(start);
    }

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(wordBreak_s1("pineapplepenapple", wordDict));
        System.out.println(wordBreak_s2("pineapplepenapple", wordDict));
    }
}
