package solution.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/11/15 21:14
 * @version 1.0
 * @topics Hash Table
 * @urllink https://leetcode-cn.com/problems/jewels-and-stones/
 */
public class P771_Jewels_and_Stones {

    public static int numJewelsInStones(String J, String S) {
        int counter = 0;
        List<Character> lst = new ArrayList<>();
        for (char ch : J.toCharArray()) {
            lst.add(ch);
        }
        for (char ch : S.toCharArray()) {
            if (lst.contains(ch)) counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }
}
