package solution.medium;

import helper.ArrayHelper;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yi-Lo
 * 2020/12/8 17:43
 * @version 1.0
 * @topics Sort、Array
 * @urllink https://leetcode-cn.com/problems/merge-intervals/
 */
public class P56_Merge_Intervals {

    public static int[][] merge(int[][] intervals) {
        // sort by start num
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            // add directly to the end of res
            if (index == -1 || interval[0] > res[index][1]) {
                res[++index] = interval;
            } else {
                // merge interval
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        ArrayHelper.println(merge(intervals));
    }
}
