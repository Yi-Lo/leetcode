package solution.easy;

/**
 * @author Yi-Lo
 * 2021/1/31 11:01
 * @version 1.0
 * @topics Bit Manipulation
 * @urllink https://leetcode-cn.com/problems/sum-of-two-integers/
 */
public class P371_Sum_of_Two_Integers {

    public static int getSum(int a, int b) {
        while (b != 0) {
            int c = a ^ b;
            b = (a & b) << 1;
            a = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
    }
}