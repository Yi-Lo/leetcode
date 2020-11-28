package solution.hard;

/**
 * @author Yi-Lo
 * 2020/11/28 18:50
 * @version 1.0
 * @topics Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/student-attendance-record-ii/
 */
public class P552_Student_Attendance_Record_II {

    private static long M = 1000000007;

    public static int checkRecord(int n) {
        long[] dp = new long[n <= 5 ? 6 : n + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 7;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((2 * dp[i - 1]) % M + (M - dp[i - 4])) % M;
        }
        long sum = dp[n];
        for (int i = 1; i <= n; i++) {
            sum += (dp[i - 1] * dp[n - i]) % M;
        }
        return (int) (sum % M);
    }

    public static void main(String[] args) {
        System.out.println(checkRecord(2));
    }
}
