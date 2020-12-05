package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/5 18:59
 * @version 1.0
 * @topics Bit Manipulation
 * @urllink https://leetcode-cn.com/problems/reverse-bits/
 */
public class P190_Reverse_Bits {

    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) + (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
