package solution.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/1/23 18:05
 * @version 1.0
 * @topics Stack
 * @urllink https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class P150_Evaluate_Reverse_Polish_Notation {

    public static int evalRPN_s1(String[] tokens) {
        List<String> operator = Arrays.asList("+", "-", "*", "/");
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (operator.contains(token)) {
                int num1 = stack.pollLast();
                int num2 = stack.pollLast();
                stack.addLast(calculate(num1, num2, token));
            } else {
                stack.addLast(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }

    public static int calculate(int num1, int num2, String token) {
        switch (token) {
            case "-":
                return num2 - num1;
            case "*":
                return num2 * num1;
            case "/":
                return num2 / num1;
            default:
                return num2 + num1;
        }
    }

    public static int pos;

    public static int evalRPN_s2(String[] tokens) {
        pos = tokens.length - 1;
        return calculate(tokens);
    }

    public static int calculate(String[] tokens) {
        String cur = tokens[pos--];
        boolean add = cur.equals("+");
        boolean sub = cur.equals("-");
        boolean mul = cur.equals("*");
        boolean div = cur.equals("/");
        if (add || sub || mul || div) {
            int a = calculate(tokens);
            int b = calculate(tokens);
            if (add) return b + a;
            if (sub) return b - a;
            if (mul) return b * a;
            if (div) return b / a;
        }
        return Integer.parseInt(cur);
    }

    public static void main(String[] args) {
        String[] token = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN_s1(token));
        System.out.println(evalRPN_s2(token));
    }
}
