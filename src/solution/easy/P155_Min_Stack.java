package solution.easy;

import java.util.Stack;

/**
 * @author Yi-Lo
 * 2020/10/23 18:36
 * @version 1.0
 * @urllink https://leetcode-cn.com/problems/min-stack/
 */
public class P155_Min_Stack {


    private Stack<Integer> xStack;
    private Stack<Integer> minStack;

    public P155_Min_Stack() {
        xStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
