package solution.hard;

import java.util.*;

/**
 * @author Yi-Lo
 * 2021/2/5 10:32
 * @version 1.0
 * @topics Graph、Topological Sort
 * @urllink https://leetcode-cn.com/problems/alien-dictionary/
 */
public class P269_Alien_Dictionary {

    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            int currLen = words[i].length(), nextLen = words[i + 1].length();
            for (int j = 0; j < currLen && j < nextLen; j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    Set<Character> set = map.getOrDefault(words[i].charAt(j), new HashSet<>());
                    set.add(words[i + 1].charAt(j));
                    map.put(words[i].charAt(j), set);
                    break;
                }
                if (currLen > nextLen && j == nextLen - 1) return "";
            }
        }
        int[] degrees = new int[26];
        Arrays.fill(degrees, -1);
        for (String str : words) {
            for (char c : str.toCharArray()) {
                degrees[c - 'a'] = 0;
            }
        }
        for (char key : map.keySet()) {
            for (char val : map.get(key)) {
                degrees[val - 'a']++;
            }
        }
        StringBuilder builder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (degrees[i] != -1) count++;
            if (degrees[i] == 0) {
                queue.add((char) ('a' + i));
            }
        }
        while (!queue.isEmpty()) {
            Character curr = queue.poll();
            builder.append(curr);
            if (map.containsKey(curr)) {
                Set<Character> set = map.get(curr);
                for (Character c : set) {
                    degrees[c - 'a']--;
                    if (degrees[c - 'a'] == 0) queue.add(c);
                }
            }
        }
        return (builder.length() != count) ? "" : builder.toString();
    }

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(alienOrder(words));
    }
}
