package solution.hard;

import java.util.Stack;

/**
 * @author Yi-Lo
 * 2020/10/25 18:03
 * @version 1.0
 * @topics Stack、Array、Two Pointers
 * @urllink https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class P42_Trapping_Rain_Water {

    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int rainArea = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                int bound = Math.min(height[i], height[stack.peek()]) - height[top];
                rainArea += width * bound;
            }
            stack.push(i);
        }
        return rainArea;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

}
