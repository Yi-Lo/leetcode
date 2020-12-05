package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/5 17:56
 * @version 1.0
 * @topics Bit Manipulation
 * @urllink https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class P191_Number_of_1_Bits {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
