package solution.hard;

import java.util.LinkedList;

/**
 * @author Yi-Lo
 * 2020/11/23 18:37
 * @version 1.0
 * @topics String、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class P32_Longest_Valid_Parentheses {

    public static int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses("()(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()(())"));
    }
}
