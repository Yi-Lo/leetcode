package solution.medium;

import structure.TrieNode;

/**
 * @author Yi-Lo
 * 2020/11/29 18:04
 * @version 1.0
 * @topics Design、Trie
 * @urllink https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class P208_Implement_Trie_Prefix_Tree {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public P208_Implement_Trie_Prefix_Tree() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null) return;
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = lastNode(word);
        if (node == null) return false;
        return node.end != 0;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return lastNode(prefix) != null;
    }

    public TrieNode lastNode(String word) {
        if (word == null) return null;
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                return null;
            }
            node = node.map[index];
        }
        return node;
    }
}
