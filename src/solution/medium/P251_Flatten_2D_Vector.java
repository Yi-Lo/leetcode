package solution.medium;

import design.Vector2D;

/**
 * @author Yi-Lo
 * 2021/2/6 21:19
 * @version 1.0
 * @topics Design
 * @urllink https://leetcode-cn.com/problems/flatten-2d-vector/
 */
public class P251_Flatten_2D_Vector {

    public static void main(String[] args) {
        int[][] v = {{1, 2}, {3}, {4}};
        Vector2D vector = new Vector2D(v);
        System.out.println(vector.next());
        System.out.println(vector.hasNext());
    }
}
