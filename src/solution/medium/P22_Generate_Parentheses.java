package solution.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/10/29 17:42
 * @version 1.0
 * @topics String、Backtracking
 * @urllink https://leetcode-cn.com/problems/generate-parentheses/
 */
public class P22_Generate_Parentheses {

    private static List<String> result = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return result;
    }

    public static void generate(int left, int right, int n, String s) {
        if (right == n) {
            result.add(s);
            return;
        }
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (left > right) {
            generate(left, right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
        System.out.println(result);
    }
}
