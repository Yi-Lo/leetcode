package structure;

/**
 * @author Yi-Lo
 * 2020/11/30 21:21
 * @version 1.0
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

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

    public boolean search(String word) {
        TrieNode node = lastNode(word);
        if (node == null) return false;
        return node.end != 0;
    }

    public boolean startWith(String prefix) {
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
