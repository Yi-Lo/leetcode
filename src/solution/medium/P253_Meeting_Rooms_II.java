package solution.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yi-Lo
 * 2021/1/15 15:40
 * @version 1.0
 * @topics Heap、Greedy、Sort
 * @urllink https://leetcode-cn.com/problems/meeting-rooms-ii/
 */
public class P253_Meeting_Rooms_II {

    public static int minMeetingRooms_s1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        Map<Integer, Integer> rooms = new HashMap<>();
        int conflict = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (rooms.containsKey(interval[0])) {
                rooms.remove(interval[0]);
            } else {
                for (int end : rooms.keySet()) {
                    if (end < interval[0]) {
                        rooms.remove(end);
                        break;
                    }
                }
            }
            if (rooms.containsKey(interval[1])) {
                conflict++;
            }
            rooms.put(interval[1], interval[0]);
        }
        return rooms.size() + conflict;
    }

    public static int minMeetingRooms_s2(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0, index = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[index]) {
                rooms++;
            } else {
                index++;
            }
        }
        return rooms;
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms_s1(new int[][]{{9, 10}, {4, 9}, {4, 17}}));
        System.out.println(minMeetingRooms_s2(new int[][]{{2, 11}, {6, 16}, {11, 16}}));
    }
}
