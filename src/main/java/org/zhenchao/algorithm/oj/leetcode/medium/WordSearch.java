package org.zhenchao.algorithm.oj.leetcode.medium;

/**
 * 79. Word Search
 *
 * @author zhenchao.wang 2017-12-02 10:45
 * @version 1.0.0
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (null == word || word.length() == 0) return false;
        if (null == board || board.length == 0 || board[0].length == 0) return false;
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (this.dfs(board, word, i, j, 0)) {
                    result = true;
                }
            }
        }
        return result;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int x) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (board[i][j] == word.charAt(x)) {
            char tmp = board[i][j];
            board[i][j] = '#';
            if (x == word.length() - 1) {
                return true;
            } else if (this.dfs(board, word, i - 1, j, x + 1)
                || this.dfs(board, word, i + 1, j, x + 1)
                || this.dfs(board, word, i, j - 1, x + 1)
                || this.dfs(board, word, i, j + 1, x + 1)) {
                return true;
            }
            // 如果查找失败，需要进行恢复
            board[i][j] = tmp;
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        // System.out.println(ws.exist(board, "ABCCED"));
        System.out.println(ws.exist(board, "SEE"));
        // System.out.println(ws.exist(board, "ABCB"));
    }

}
