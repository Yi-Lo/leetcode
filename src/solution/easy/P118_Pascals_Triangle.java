package solution.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/1/17 16:42
 * @version 1.0
 * @topics Array
 * @urllink https://leetcode-cn.com/problems/pascals-triangle/
 */
public class P118_Pascals_Triangle {

    public static List<List<Integer>> generate_s1(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        res.add(Arrays.asList(1));
        if (numRows == 1) return res;
        res.add(Arrays.asList(1, 1));
        List<Integer> base = res.get(1);
        for (int row = 2; row < numRows; row++) {
            List<Integer> up = res.get(row - 1);
            List<Integer> down = new ArrayList<>(base);
            for (int i = 1; i < row; i++) {
                down.add(i, up.get(i - 1) + up.get(i));
            }
            res.add(down);
        }
        return res;
    }

    public static List<List<Integer>> generate_s2(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate_s1(5));
        System.out.println(generate_s2(5));
    }
}
