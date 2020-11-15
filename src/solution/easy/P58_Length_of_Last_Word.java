package solution.easy;

/**
 * @author Yi-Lo
 * 2020/11/15 21:14
 * @version 1.0
 * @topics String
 * @urllink https://leetcode-cn.com/problems/length-of-last-word/
 */
public class P58_Length_of_Last_Word {

    public static int lengthOfLastWord_s1(String s) {
        int res = 0, space = ' ', len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != space) res++;
            if (s.charAt(i) == space && res > 0) break;
        }
        return res;
    }

    public static int lengthOfLastWord_s2(String s) {
        String[] arr = s.split(" ");
        if (arr.length == 0) return 0;
        return arr[arr.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord_s1("a "));
    }
}
