package solution.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/1/30 10:15
 * @version 1.0
 * @topics String
 * @urllink https://leetcode-cn.com/problems/fizz-buzz/
 */
public class P412_Fizz_Buzz {

    public static List<String> fizzBuzz_s1(int n) {
        List<String> list = new ArrayList<>();
        String fizz = "Fizz", buzz = "Buzz";
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            builder.setLength(0);
            if (i % 3 == 0) builder.append(fizz);
            if (i % 5 == 0) builder.append(buzz);
            if (builder.length() == 0) builder.append(i);
            list.add(builder.toString());
        }
        return list;
    }

    public static List<String> fizzBuzz_s2(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz_s1(15));
        System.out.println(fizzBuzz_s2(15));
    }
}
