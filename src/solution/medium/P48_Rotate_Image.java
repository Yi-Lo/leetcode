package solution.medium;

import helper.ArrayHelper;

/**
 * @author Yi-Lo
 * 2021/1/3 17:56
 * @version 1.0
 * @topics Array
 * @urllink https://leetcode-cn.com/problems/rotate-image/
 */
public class P48_Rotate_Image {

    public static void rotate(int[][] matrix) {
        int tR = 0, dR = matrix.length - 1;
        int tC = 0, dC = matrix[0].length - 1;
        while (tR < dR) rotateEdge(matrix, tR++, tC++, dR--, dC--);
    }

    public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC, temp = 0;
        for (int i = 0; i != times; i++) {
            temp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        ArrayHelper.println(matrix);
        rotate(matrix);
        ArrayHelper.println(matrix);
    }
}
