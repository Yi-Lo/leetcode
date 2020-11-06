package solution.medium;

import java.util.*;

/**
 * @author Yi-Lo
 * 2020/11/6 17:15
 * @version 1.0
 * @topics Backtracking、Breadth-first Search
 * @urllink https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
public class P433_Minimum_Genetic_Mutation {

    private static int result = -1;

    private static int counter = 1;

    public static int minMutation_s1(String start, String end, String[] bank) {
        if (bank.length == 0 || start.length() != end.length() || !exist(end, bank)) {
            return result;
        }
        backtrack(start, end, bank, new ArrayList<>());
        return result;
    }


    public static void backtrack(String start, String end, String[] bank, List<String> visit) {
        if (diff(start, end) == 1) {
            result = result < 0 ? counter : Math.min(result, counter);
            return;
        }
        for (String gene : bank) {
            if (!gene.equals(end) && !visit.contains(gene)) {
                if (diff(start, gene) == 1) {
                    counter++;
                    visit.add(gene);
                    backtrack(gene, end, bank, visit);
                    visit.remove(visit.size() - 1);
                    counter--;
                }
            }
        }
    }

    public static int diff(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean exist(String end, String[] bank) {
        for (String gene : bank) {
            if (gene.equals(end)) {
                return true;
            }
        }
        return false;
    }


    public static int minMutation_s2(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        Set<String> set = new HashSet<>();
        for (String gene : bank) {
            set.add(gene);
        }
        int level = 0;
        char[] chs = {'A', 'C', 'G', 'T'};
        Set<String> visit = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        visit.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(end)) return level;
                char[] arr = curr.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (char ch : chs) {
                        arr[j] = ch;
                        String next = new String(arr);
                        if (!visit.contains(next) && set.contains(next)) {
                            visit.add(next);
                            queue.add(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(minMutation_s1(start, end, bank));
    }

}
