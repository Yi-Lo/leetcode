package solution.medium;

/**
 * @author Yi-Lo
 * 2021/2/5 10:36
 * @version 1.0
 * @topics Array
 * @urllink https://leetcode-cn.com/problems/find-the-celebrity/
 */
public class P277_Find_the_Celebrity extends Relation {

    public static int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) candidate = i;
        }
        for (int i = 0; i < n; i++) {
            if (candidate == i) continue;
            if (knows(candidate, i) || !knows(i, candidate)) return -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(findCelebrity(3));
    }
}

class Relation {

    public static int[][] graph = {{1, 1, 0}, {0, 1, 0}, {1, 1, 1}};

    public static boolean knows(int a, int b) {
        return graph[a][b] == 1;
    }
}