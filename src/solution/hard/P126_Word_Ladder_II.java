package solution.hard;

import java.util.*;

/**
 * @author Yi-Lo
 * 2020/11/7 18:30
 * @version 1.0
 * @topics Breadth-first Search、Array、String、Backtracking
 * @urllink https://leetcode-cn.com/problems/word-ladder-ii/
 */
public class P126_Word_Ladder_II {

    private static int length = Integer.MAX_VALUE;

    private static List<List<String>> result = new ArrayList<>();

    public static List<List<String>> findLadders_s1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || wordList.isEmpty()) {
            return result;
        }
        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);
        backtrack(queue, endWord, wordList);
        removeLongerLadders();
        return result;
    }

    public static void backtrack(LinkedList<String> queue, String end, List<String> words) {
        if (transOk(queue.peekLast(), end)) {
            if (queue.size() < length) {
                queue.addLast(end);
                length = queue.size();
                result.add(new ArrayList<>(queue));
                queue.pollLast();
            }
        }
        for (String word : words) {
            if (!word.equals(end) && !queue.contains(word) && transOk(queue.peekLast(), word)) {
                queue.addLast(word);
                backtrack(queue, end, words);
                queue.pollLast();
            }
        }
    }

    public static boolean transOk(String start, String end) {
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static void removeLongerLadders() {
        Iterator<List<String>> iterator = result.iterator();
        while (iterator.hasNext()) {
            List<String> ans = iterator.next();
            if (ans.size() > length) {
                iterator.remove();
            }
        }
    }

    public static List<List<String>> findLadders_s2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || wordList.isEmpty()) {
            return result;
        }
        Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>();
        qs.add(beginWord);
        qe.add(endWord);
        Map<String, List<String>> map = new HashMap<>();
        traverse(dict, qs, qe, map, false);
        List<String> sol = new ArrayList<>(Arrays.asList(beginWord));
        buildList(beginWord, endWord, map, sol);
        return result;
    }

    public static boolean traverse(Set<String> dict, Set<String> qs, Set<String> qe, Map<String, List<String>> map, boolean flip) {
        if (qs.isEmpty()) return false;
        if (qs.size() > qe.size()) {
            return traverse(dict, qe, qs, map, !flip);
        }
        dict.removeAll(qs);
        dict.removeAll(qe);
        boolean done = false;
        Set<String> nq = new HashSet<>();
        for (String w : qs) {
            for (int i = 0; i < w.length(); i++) {
                char[] ch = w.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == w.charAt(i)) continue;
                    ch[i] = c;
                    String nb = new String(ch);
                    String key = flip ? nb : w;
                    String val = flip ? w : nb;
                    List<String> lst = map.containsKey(key) ? map.get(key) : new ArrayList<>();
                    if (qe.contains(nb)) {
                        done = true;
                        lst.add(val);
                        map.put(key, lst);
                    }
                    if (!done && dict.contains(nb)) {
                        nq.add(nb);
                        lst.add(val);
                        map.put(key, lst);
                    }
                }
            }
        }
        return done || traverse(dict, qe, nq, map, !flip);
    }

    public static void buildList(String start, String end, Map<String, List<String>> map, List<String> sol) {
        if (start.equals(end)) {
            result.add(new ArrayList<>(sol));
        }
        if (!map.containsKey(start)) {
            return;
        }
        for (String word : map.get(start)) {
            sol.add(word);
            buildList(word, end, map, sol);
            sol.remove(sol.size() - 1);
        }
    }

    public static void main(String[] args) {
        String beginWord = "qa";
        String endWord = "sq";
        List<String> wordList = Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
        System.out.println(findLadders_s2(beginWord, endWord, wordList));
    }

}
