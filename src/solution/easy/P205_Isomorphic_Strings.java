package solution.easy;

import java.util.HashMap;

/**
 * @author Yi-Lo
 * 2020/12/17 17:20
 * @version 1.0
 * @topics Hash Table
 * @urllink https://leetcode-cn.com/problems/isomorphic-strings/
 */
public class P205_Isomorphic_Strings {

    public static boolean isIsomorphic_s1(String s, String t) {
        char[] chs = s.toCharArray(), cht = t.toCharArray();
        HashMap<Character, Character> k2v = new HashMap<>();
        HashMap<Character, Character> v2k = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            char cs = chs[i], ct = cht[i];
            if (k2v.containsKey(cs)) {
                char ch = k2v.get(cs);
                if (ct != ch) return false;
            } else {
                if (v2k.containsKey(ct)) {
                    char ch = v2k.get(ct);
                    if (cs != ch) return false;
                }
                k2v.put(cs, ct);
                v2k.put(ct, cs);
            }
        }
        return true;
    }

    public static boolean isIsomorphic_s2(String s, String t) {
        char[] chs = s.toCharArray(), cht = t.toCharArray();
        int[] preIndexOfs = new int[256], preIndexOft = new int[256];
        for (int i = 0; i < chs.length; i++) {
            if (preIndexOfs[chs[i]] != preIndexOft[cht[i]]) return false;
            preIndexOfs[chs[i]] = preIndexOft[cht[i]] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic_s2("ab", "aa"));
        System.out.println(isIsomorphic_s2("egg", "add"));
        System.out.println(isIsomorphic_s2("foo", "bar"));
        System.out.println(isIsomorphic_s2("paper", "title"));
    }
}
