package solution.easy;

/**
 * @author Yi-Lo
 * 2021/1/24 18:08
 * @version 1.0
 * @topics Math
 * @urllink https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class P171_Excel_Sheet_Column_Number {

    public static int titleToNumber(String s) {
        int sum = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int num = chs[i] - 'A' + 1;
            int power = chs.length - 1 - i;
            sum += num * Math.pow(26, power);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }
}
