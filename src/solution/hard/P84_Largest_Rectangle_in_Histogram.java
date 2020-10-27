package solution.hard;

import java.util.Stack;

/**
 * @author Yi-Lo
 * 2020/10/24 17:29
 * @version 1.0
 * @urllink https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class P84_Largest_Rectangle_in_Histogram {

    public static int largestRectangleArea(int[] heights) {
        Stack<Element> stack = new Stack<>();
        stack.push(new Element(-1, -1));
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (heights[i] < stack.peek().getVal()) {
                Element element = stack.pop();
                maxArea = Math.max(maxArea, element.val * (i - stack.peek().getPos() - 1));
            }
            stack.push(new Element(i, heights[i]));
        }
        while (stack.size() > 1) {
            Element element = stack.pop();
            maxArea = Math.max(maxArea, element.val * (heights.length - stack.peek().getPos() - 1));
        }
        return maxArea;
    }

    static class Element {

        private int pos;
        private int val;

        public Element(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }

        public int getPos() {
            return pos;
        }

        public int getVal() {
            return val;
        }
    }

    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {6, 7, 5, 2, 4, 5, 9, 3};
        System.out.println(largestRectangleArea(heights));
    }
}
