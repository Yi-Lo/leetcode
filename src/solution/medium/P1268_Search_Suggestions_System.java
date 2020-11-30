package solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/11/30 18:55
 * @version 1.0
 * @topics String
 * @urllink https://leetcode-cn.com/problems/search-suggestions-system/
 */
public class P1268_Search_Suggestions_System {

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        TrieNode root = new TrieNode();
        for (String product : products) {
            TrieNode node = root;
            int index = 0;
            for (char ch : product.toCharArray()) {
                index = ch - 'a';
                if (node.map[index] == null) {
                    node.map[index] = new TrieNode();
                }
                node = node.map[index];
                if (node.words.size() < 3) {
                    node.words.add(product);
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;
        for (int i = 0; i < searchWord.length(); i++) {
            node = node.map[searchWord.charAt(i) - 'a'];
            if (node == null) {
                for (int j = i; j < searchWord.length(); j++) {
                    result.add(Collections.EMPTY_LIST);
                }
                break;
            }
            result.add(node.words);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        System.out.println(suggestedProducts(products, "mouse"));
    }
}

class TrieNode {
    TrieNode[] map;
    List<String> words;

    public TrieNode() {
        words = new ArrayList<>();
        map = new TrieNode[26];
    }
}
