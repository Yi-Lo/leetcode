package solution.easy;

/**
 * @author Yi-Lo
 * 2020/11/9 19:43
 * @version 1.0
 * @topics Greedy
 * @urllink https://leetcode-cn.com/problems/lemonade-change/
 */
public class P860_Lemonade_Change {

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five < 1) return false;
                ten++;
                five--;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(bills));
    }

}
