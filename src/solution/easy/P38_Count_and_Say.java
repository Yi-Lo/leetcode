package solution.easy;

/**
 * @author Yi-Lo
 * 2021/1/16 13:32
 * @version 1.0
 * @topics String
 * @urllink https://leetcode-cn.com/problems/count-and-say/
 */
public class P38_Count_and_Say {

    public static String countAndSay(int n) {
        if (n <= 1) return "1";
        String str = countAndSay(n - 1);
        StringBuilder say = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                say.append(count).append(str.charAt(i));
                count = 0;
            }
        }
        return say.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
