package solution.medium;

import java.util.*;

/**
 * @author Yi-Lo
 * 2020/11/7 18:27
 * @version 1.0
 * @topics Breadth-first Search
 * @urllink https://leetcode-cn.com/problems/word-ladder/
 */
public class P127_Word_Ladder {

    private static int result = 0;


    public static int ladderLength_s1(String beginWord, String endWord, List<String> wordList) {
        if (wordList.isEmpty() || !wordList.contains(endWord)) {
            return result;
        }
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast(beginWord);
        backtrack(queue, endWord, wordList);
        return result;
    }

    public static void backtrack(LinkedList<String> queue, String end, List<String> wordList) {
        if (next(queue.peekLast(), end)) {
            queue.addLast(end);
            result = (result == 0) ? queue.size() : Math.min(result, queue.size());
            queue.pollLast();
            return;
        }
        for (String word : wordList) {
            if (!word.equals(end) && !queue.contains(word) && next(word, queue.peekLast())) {
                queue.add(word);
                backtrack(queue, end, wordList);
                queue.pollLast();
            }
        }
    }

    public static boolean next(String start, String end) {
        int count = 0;
        char[] arr1 = start.toCharArray();
        char[] arr2 = end.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static int ladderLength_s2(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>(), vis = new HashSet<>();
        qs.add(beginWord);
        // all transformed words must be in dict (including endWord)
        if (dict.contains(endWord)) qe.add(endWord);
        for (int len = 2; !qs.isEmpty(); len++) {
            Set<String> nq = new HashSet<>();
            for (String w : qs) {
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue;
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        // meet from two ends
                        if (qe.contains(nb)) return len;
                        // not meet yet, vis is safe to use
                        if (dict.contains(nb) && vis.add(nb)) nq.add(nb);
                    }
                }
            }
            // switch to small one to traverse from other end
            qs = (nq.size() < qe.size()) ? nq : qe;
            qe = (qs == nq) ? qe : nq;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "a";
        String endWord = "c";
        List<String> wordList = Arrays.asList("a", "b", "c");
        System.out.println(ladderLength_s2(beginWord, endWord, wordList));
    }

}
