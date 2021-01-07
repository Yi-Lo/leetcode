package solution.medium;

/**
 * @author Yi-Lo
 * 2021/1/7 12:49
 * @version 1.0
 * @topics Tree、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class P96_Unique_Binary_Search_Trees {

    public static int numTrees_s1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static int numTrees_s2(int n) {
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    public static void main(String[] args) {
        System.out.println(numTrees_s1(3));
        System.out.println(numTrees_s2(3));
    }
}
