package solution.medium;

import java.util.Stack;

/**
 * @author Yi-Lo
 * 2021/1/31 11:03
 * @version 1.0
 * @topics Stack、String
 * @urllink https://leetcode-cn.com/problems/basic-calculator-ii/
 */
public class P227_Basic_Calculator_II {

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0, number = 0, operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }
            if ("+-*/".indexOf(ch) >= 0 || i == s.length() - 1) {
                if ("*/".indexOf(operator) >= 0) {
                    result -= stack.peek();
                }
                switch (operator) {
                    case '+':
                        stack.push(number);
                        break;
                    case '-':
                        stack.push(-number);
                        break;
                    case '*':
                        stack.push(stack.pop() * number);
                        break;
                    case '/':
                        stack.push(stack.pop() / number);
                        break;
                }
                number = 0;
                operator = ch;
                result += stack.peek();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("2*3+4"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate("1-1+1"));
        System.out.println(calculate("1-1-1"));
        System.out.println(calculate("32+20*5"));
    }
}
