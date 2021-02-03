package solution.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/2/3 11:23
 * @version 1.0
 * @topics Heap、Binary Indexed Tree、Segment Tree、Divide and Conquer、Line Sweep
 * @urllink https://leetcode-cn.com/problems/the-skyline-problem/
 */
public class P218_The_Skyline_Problem {

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        int len = buildings.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) return result;
        if (len == 1) {
            result.add(new ArrayList<Integer>() {{
                add(buildings[0][0]);
                add(buildings[0][2]);
            }});
            result.add(new ArrayList<Integer>() {{
                add(buildings[0][1]);
                add(0);
            }});
            return result;
        }
        List<List<Integer>> leftSkyline, rightSkyline;
        leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, len / 2));
        rightSkyline = getSkyline(Arrays.copyOfRange(buildings, len / 2, len));
        return mergeSkylines(leftSkyline, rightSkyline);
    }

    public static List<List<Integer>> mergeSkylines(List<List<Integer>> left, List<List<Integer>> right) {
        int sizeL = left.size(), sizeR = right.size();
        int idxL = 0, idxR = 0, currY = 0, leftY = 0, rightY = 0;
        int x, maxY;
        List<List<Integer>> result = new ArrayList<>();
        while ((idxL < sizeL) && (idxR < sizeR)) {
            List<Integer> pointL = left.get(idxL);
            List<Integer> pointR = right.get(idxR);
            if (pointL.get(0) < pointR.get(0)) {
                x = pointL.get(0);
                leftY = pointL.get(1);
                idxL++;
            } else {
                x = pointR.get(0);
                rightY = pointR.get(1);
                idxR++;
            }
            maxY = Math.max(leftY, rightY);
            if (currY != maxY) {
                update(result, x, maxY);
                currY = maxY;
            }
        }
        appendSkyline(result, left, idxL, sizeL, currY);
        appendSkyline(result, right, idxR, sizeR, currY);
        return result;
    }

    public static void appendSkyline(List<List<Integer>> result, List<List<Integer>> skyline, int i, int n, int currY) {
        while (i < n) {
            List<Integer> point = skyline.get(i++);
            int x = point.get(0), y = point.get(1);
            if (currY != y) {
                update(result, x, y);
                currY = y;
            }
        }
    }

    public static void update(List<List<Integer>> result, int x, int y) {
        if (result.isEmpty() || result.get(result.size() - 1).get(0) != x) {
            result.add(new ArrayList<Integer>() {{
                add(x);
                add(y);
            }});
        } else {
            result.get(result.size() - 1).set(1, y);
        }
    }

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(getSkyline(buildings));
    }
}
