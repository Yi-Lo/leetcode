package solution.medium;

import helper.ArrayHelper;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Yi-Lo
 * 2021/1/5 14:36
 * @version 1.0
 * @topics Stack、Hash Table
 * @urllink https://leetcode-cn.com/problems/daily-temperatures/
 */
public class P739_Daily_Temperatures {

    public static int[] dailyTemperatures_s1(int[] T) {
        int[] wait = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    wait[i] = j - i;
                    break;
                }
            }
        }
        return wait;
    }

    public static int[] dailyTemperatures_s2(int[] T) {
        int[] wait = new int[T.length];
        Stack<Integer> day = new Stack<>(), temperature = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!temperature.isEmpty() && T[i] > temperature.peek()) {
                temperature.pop();
                wait[day.peek()] = i - day.pop();
            }
            day.add(i);
            temperature.add(T[i]);
        }
        return wait;
    }

    public static int[] dailyTemperatures_s3(int[] T) {
        int[] wait = new int[T.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int preIndex = stack.pop();
                wait[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return wait;
    }

    public static int[] dailyTemperatures_s4(int[] T) {
        int[] wait = new int[T.length];
        int max = T[T.length - 1];
        for (int i = T.length - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                wait[i] = 1;
            } else if (T[i] >= max) {
                max = T[i];
                wait[i] = 0;
            } else {
                int idx = (i + 1) + wait[i + 1];
                while (T[i] >= T[idx]) idx += wait[idx];
                wait[i] = idx - i;
            }
        }
        return wait;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        ArrayHelper.println(dailyTemperatures_s1(T));
        ArrayHelper.println(dailyTemperatures_s2(T));
        ArrayHelper.println(dailyTemperatures_s3(T));
        ArrayHelper.println(dailyTemperatures_s4(T));
    }
}
