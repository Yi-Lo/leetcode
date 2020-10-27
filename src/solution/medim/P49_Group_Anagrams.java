package solution.medim;

import java.util.*;

/**
 * @author Yi-Lo
 * 2020/10/26 17:28
 * @version 1.0
 * @urllink https://leetcode-cn.com/problems/group-anagrams/
 */
public class P49_Group_Anagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            List<String> lst = map.get(key);
            if (lst == null) {
                lst = new ArrayList<>();
                map.put(key, lst);
            }
            lst.add(str);
        }
        for (List<String> value : map.values()) {
            resList.add(value);
        }
        return resList;
    }

    public static String getKey(String str) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char ch : str.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                count = 0;
            }
            map.put(ch, ++count);
        }
        return map.toString();
    }

    public static List<List<String>> groupAnagrams_s1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] counter = new char[26];
            for (char ch : str.toCharArray()) {
                counter[ch - 'a']++;
            }
            String key = String.valueOf(counter);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
//        String[] strs = {"aa", "aa"};
//        String[] strs = {"ddddddddddg", "dgggggggggg"};
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        System.out.println(groupAnagrams_s1(strs));
    }
}
