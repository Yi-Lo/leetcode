package solution.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/11/30 18:50
 * @version 1.0
 * @topics Trie、Backtracking
 * @urllink https://leetcode-cn.com/problems/word-search-ii/
 */
public class P212_Word_Search_II {

    private static int[] dx = {0, 1, -1, 0};

    private static int[] dy = {1, 0, 0, -1};

    private static List<String> result = new ArrayList<>();

    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (Character ch : word.toCharArray()) {
                if (node.children.containsKey(ch)) {
                    node = node.children.get(ch);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(ch, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                DFS(board, i, j, root);
            }
        }
        return result;
    }

    public static void DFS(char[][] board, int x, int y, TrieNode parent) {
        char ch = board[x][y];
        TrieNode node = parent.children.get(ch);
        if (node == null) return;
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[x][y] = '@';
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i], ty = y + dy[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] == '@') continue;
            if (node.children.containsKey(board[tx][ty])) {
                DFS(board, tx, ty, node);
            }
        }
        board[x][y] = ch;
        if (node.children.isEmpty()) {
            parent.children.remove(ch);
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null;

    public TrieNode() {
    }
}


