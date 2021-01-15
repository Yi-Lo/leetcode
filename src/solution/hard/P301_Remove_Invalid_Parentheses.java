package solution.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/1/15 15:42
 * @version 1.0
 * @topics Depth-first Search、Breadth-first Search
 * @urllink https://leetcode-cn.com/problems/remove-invalid-parentheses/
 */
public class P301_Remove_Invalid_Parentheses {

    public static List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public static void remove(String s, List<String> ans, int pi, int pj, char[] pair) {
        for (int stack = 0, i = pi; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) stack++;
            if (s.charAt(i) == pair[1]) stack--;
            if (stack >= 0) continue;
            for (int j = pj; j <= i; j++) {
                if (s.charAt(j) == pair[1] && (j == pj || s.charAt(j - 1) != pair[1])) {
                    remove(new StringBuilder(s).deleteCharAt(j).toString(), ans, i, j, pair);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        } else {
            ans.add(reversed);
        }
    }

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses(")("));
        System.out.println(removeInvalidParentheses("(j))("));
        System.out.println(removeInvalidParentheses(")()("));
        System.out.println(removeInvalidParentheses("()())()"));
        System.out.println(removeInvalidParentheses("(a)())()"));
        System.out.println(removeInvalidParentheses("((((((())))(("));
    }
}
