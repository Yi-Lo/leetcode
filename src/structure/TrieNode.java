package structure;

/**
 * @author Yi-Lo
 * 2020/11/29 20:58
 * @version 1.0
 */
public class TrieNode {
    public int path;
    public int end;
    public TrieNode[] map;

    public TrieNode() {
        path = 0;
        end = 0;
        map = new TrieNode[26];
    }
}
