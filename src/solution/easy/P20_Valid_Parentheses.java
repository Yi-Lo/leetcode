package solution.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Yi-Lo
 * 2020/10/23 15:53
 * @version 1.0
 * @urllink https://leetcode-cn.com/problems/valid-parentheses/
 */
public class P20_Valid_Parentheses {

    public static boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            char chr = arr[i];
            if (chr == '(' || chr == '[' || chr == '{') {
                stack.push(chr);
            } else {
                if (stack.size() > 0) {
                    int top = stack.peek();
                    if (top == (chr - 1) || top == (chr - 2)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid_s1(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pair.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pair.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid_s1("]"));
        System.out.println(isValid_s1("(])"));
        System.out.println(isValid_s1("()[]{}"));
    }
}
