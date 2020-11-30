package solution.medium;

import structure.Trie;

/**
 * @author Yi-Lo
 * 2020/11/29 18:04
 * @version 1.0
 * @topics Design、Trie
 * @urllink https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class P208_Implement_Trie_Prefix_Tree {

    private Trie trie;

    /**
     * Initialize your data structure here.
     */
    public P208_Implement_Trie_Prefix_Tree() {
        trie = new Trie();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        trie.insert(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return trie.search(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return trie.startWith(prefix);
    }

}
