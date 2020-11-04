package solution.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/11/4 17:41
 * @version 1.0
 * @topics String、Backtracking
 * @urllink https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class P17_Letter_Combinations_of_a_Phone_Number {

    private static List<String> result = new ArrayList<>();

    private static String[] array = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder());
        return result;
    }

    public static void backtrack(String digits, int start, StringBuilder builder) {
        if (digits.length() == builder.length()) {
            result.add(builder.toString());
            return;
        }
        String str = getStr(digits.charAt(start));
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            builder.append(chars[i]);
            backtrack(digits, start + 1, builder);
            builder.deleteCharAt(start);
        }
    }

    public static String getStr(char num) {
        return array[num - 50];
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
