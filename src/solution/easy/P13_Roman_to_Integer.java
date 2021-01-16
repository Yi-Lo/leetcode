package solution.easy;

/**
 * @author Yi-Lo
 * 2021/1/16 13:27
 * @version 1.0
 * @topics Math、String
 * @urllink https://leetcode-cn.com/problems/roman-to-integer/
 */
public class P13_Roman_to_Integer {

    public static int romanToInt(String s) {
        int sum = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int v1 = getValue(chs[i]);
            if (i == chs.length - 1) {
                sum += v1;
            } else {
                int v2 = getValue(chs[i + 1]);
                if (v2 <= v1) {
                    sum += v1;
                } else {
                    sum += v2 - v1;
                    i++;
                }
            }
        }
        return sum;
    }

    public static int getValue(char c) {
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default :return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
