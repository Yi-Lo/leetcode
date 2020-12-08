package helper;

/**
 * @author Yi-Lo
 * 2020/12/8 17:50
 * @version 1.0
 */
public class ArrayHelper {

    private static String table = "\t";

    private static String enter = "\r\n";

    private static StringBuilder builder = new StringBuilder();

    public static void println(int[] arr) {
        builder.setLength(0);
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]).append(table);
        }
        System.out.println(builder.toString());
    }

    public static void println(int[][] arr) {
        builder.setLength(0);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                builder.append(arr[i][j]).append(table);
            }
            builder.append(enter);
        }
        System.out.println(builder.toString());
    }
}
