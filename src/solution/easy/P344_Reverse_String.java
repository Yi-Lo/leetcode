package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/13 18:10
 * @version 1.0
 * @topics Two Pointers、String
 * @urllink https://leetcode-cn.com/problems/reverse-string/
 */
public class P344_Reverse_String {

    public static void reverseString(char[] s) {
        int head = 0, tail = s.length - 1;
        while (head < tail) {
            char temp = s[head];
            s[head++] = s[tail];
            s[tail--] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }
}
