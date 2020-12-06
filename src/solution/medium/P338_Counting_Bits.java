package solution.medium;

/**
 * @author Yi-Lo
 * 2020/12/6 18:45
 * @version 1.0
 * @topics Bit Manipulation、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/counting-bits/
 */
public class P338_Counting_Bits {

    public static int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] += bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}
