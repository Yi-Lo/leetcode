package solution.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yi-Lo
 * 2021/1/11 11:51
 * @version 1.0
 * @topics Depth-first Search、Breadth-first Search、Graph、Topological Sort
 * @urllink https://leetcode-cn.com/problems/course-schedule/
 */
public class P207_Course_Schedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        int[] indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int u = queue.poll();
            for (int v : edges.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(canFinish(2, prerequisites));
    }
}
