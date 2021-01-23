package solution.medium;

import helper.ArrayHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yi-Lo
 * 2021/1/23 18:06
 * @version 1.0
 * @topics Depth-first Search、Breadth-first Search、Graph、Topological Sort
 * @urllink https://leetcode-cn.com/problems/course-schedule-ii/
 */
public class P210_Course_Schedule_II {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int index = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order[index++] = u;
            for (int v : edges.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return order;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        ArrayHelper.println(findOrder(4, prerequisites));
    }
}
