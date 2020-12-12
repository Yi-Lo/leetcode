package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/12 17:29
 * @version 1.0
 * @topics Hash Table、String
 * @urllink https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class P387_First_Unique_Character_in_a_String {

    public static int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] chs = s.toCharArray();
        for (char ch : chs) count[ch - 'a']++;
        for (char ch : chs) {
            if (count[ch - 'a'] == 1) {
                return s.indexOf(ch);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
