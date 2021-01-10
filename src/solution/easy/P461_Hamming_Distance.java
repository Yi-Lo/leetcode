package solution.easy;

/**
 * @author Yi-Lo
 * 2021/1/10 12:09
 * @version 1.0
 * @topics Bit Manipulation
 * @urllink https://leetcode-cn.com/problems/hamming-distance/
 */
public class P461_Hamming_Distance {

    public static int hammingDistance(int x, int y) {
        int n = x ^ y, c = 0;
        while (n != 0) {
            n = n & (n - 1);
            c++;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
