package solution.hard;

import java.util.HashMap;

/**
 * @author Yi-Lo
 * 2021/2/1 10:31
 * @version 1.0
 * @topics Hash Table、Math
 * @urllink https://leetcode-cn.com/problems/max-points-on-a-line/
 */
public class P149_Max_Points_on_a_Line {

    public static int maxPoints(int[][] points) {
        if (points.length < 3) return points.length;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int max = 0, cover = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    cover++;
                    continue;
                }
                int gcd = gcd(x, y);
                x /= gcd;
                y /= gcd;
                String key = x + "@" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            res = Math.max(res, max + cover + 1);
        }
        return res;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(maxPoints(points));
    }
}
