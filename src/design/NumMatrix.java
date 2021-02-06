package design;

/**
 * @author Yi-Lo
 * 2021/2/6 21:23
 * @version 1.0
 */
public class NumMatrix {

    public int[][] prefix;
    public int[][] matrix;
    public int rows, cols;

    public NumMatrix(int[][] matrix) {
        if (matrix == null) return;
        if (matrix.length == 0) return;
        if (matrix[0].length == 0) return;
        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        prefix = new int[rows][cols + 1];
        for (int row = 0; row < rows; row++) {
            calculatePrefix(row, 0);
        }
    }

    public void update(int row, int col, int val) {
        matrix[row][col] = val;
        calculatePrefix(row, col);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            sum += prefix[row][col2 + 1] - prefix[row][col1];
        }
        return sum;
    }

    public void calculatePrefix(int row, int col) {
        for (int i = col; i < cols; i++) {
            prefix[row][i + 1] = prefix[row][i] + matrix[row][i];
        }
    }
}
