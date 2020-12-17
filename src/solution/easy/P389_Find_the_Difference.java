package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/17 18:41
 * @version 1.0
 * @topics Bit Manipulation、Hash Table
 * @urllink https://leetcode-cn.com/problems/find-the-difference/
 */
public class P389_Find_the_Difference {

    public static char findTheDifference_s1(String s, String t) {
        char ans = t.charAt(s.length());
        char[] chs = s.toCharArray(), cht = t.toCharArray();
        int[] ss = new int[256], tt = new int[256];
        for (int i = 0; i < chs.length; i++) {
            ss[chs[i]]++;
            tt[cht[i]]++;
        }
        for (int i = 0; i < ss.length; i++) {
            if (tt[i] > ss[i]) {
                ans = (char) i;
                return ans;
            }
        }
        return ans;
    }

    public static char findTheDifference_s2(String s, String t) {
        int len = s.length();
        int sums = 0, sumt = t.charAt(len);
        for (int i = 0; i < len; i++) {
            sums += s.charAt(i);
            sumt += t.charAt(i);
        }
        return (char) (sumt - sums);
    }

    public static char findTheDifference_s3(String s, String t) {
        int len = s.length();
        char ans = t.charAt(len);
        for (int i = 0; i < len; i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference_s1("abcd", "abcde"));
        System.out.println(findTheDifference_s1("", "y"));
        System.out.println(findTheDifference_s1("a", "aa"));
        System.out.println(findTheDifference_s1("ae", "aea"));
    }
}
