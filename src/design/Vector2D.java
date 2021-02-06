package design;

/**
 * @author Yi-Lo
 * 2021/2/6 21:20
 * @version 1.0
 */
public class Vector2D {

    private int row;
    private int col;
    private int[][] data;

    public Vector2D(int[][] v) {
        row = col = 0;
        this.data = v;
    }

    public int next() {
        if (data[row].length > col) {
            return data[row][col++];
        }
        col = 0;
        return data[++row][col++];
    }

    public boolean hasNext() {
        while (row < data.length) {
            if (data[row].length > col) {
                return true;
            }
            row++;
            col = 0;
        }
        return false;
    }
}
