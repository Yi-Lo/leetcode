package solution.medium;

import java.util.List;

/**
 * @author Yi-Lo
 * 2020/11/14 18:06
 * @version 1.0
 * @topics Array、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/triangle/
 */
public class P120_Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int miniTotal = f[0];
        for (int i = 1; i < n; i++) {
            miniTotal = Math.min(miniTotal, f[i]);
        }
        return miniTotal;
    }
}
