package solution.easy;

import java.util.Arrays;

/**
 * @author Yi-Lo
 * 2020/11/10 16:16
 * @version 1.0
 * @topics Greedy
 * @urllink https://leetcode-cn.com/problems/assign-cookies/
 */
public class P455_Assign_Cookies {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && g[i] <= s[index]) {
                count++;
                index--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }
}
