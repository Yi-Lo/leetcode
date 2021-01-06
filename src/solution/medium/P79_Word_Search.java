package solution.medium;

/**
 * @author Yi-Lo
 * 2021/1/6 14:30
 * @version 1.0
 * @topics Array、Backtracking
 * @urllink https://leetcode-cn.com/problems/word-search/
 */
public class P79_Word_Search {

    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] array = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != array[0]) continue;
                if (backtrack(board, array, i, j, 0)) return true;
            }
        }
        return false;
    }

    public static boolean backtrack(char[][] board, char[] word, int i, int j, int idx) {
        if (idx == word.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] == '@' || board[i][j] != word[idx]) return false;
        char bak = board[i][j];
        board[i][j] = '@';
        if (backtrack(board, word, i, j + 1, idx + 1)) return true;
        if (backtrack(board, word, i + 1, j, idx + 1)) return true;
        if (backtrack(board, word, i, j - 1, idx + 1)) return true;
        if (backtrack(board, word, i - 1, j, idx + 1)) return true;
        board[i][j] = bak;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
    }
}
