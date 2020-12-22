package oj.top100.review01;

public class Q79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[i].length; i1++) {
                if (word.charAt(0) == board[i][i1]) {
                    if (dfs(board, i, i1, new boolean[board.length][board[0].length], word)) return true;
                }
            }
        }

        return false;
    }

    boolean dfs(char[][] board, int i, int j, boolean[][] vis, String word) {
        if (word.length() == 0) return true;
        if (board[i][j] != word.charAt(0)) return false;
        vis[i][j] = true;

        if (word.length() == 1) return true;
        if (i > 0 && !vis[i - 1][j] && dfs(board, i - 1, j, vis, word.substring(1))) return true;
        if (j > 0 && !vis[i][j - 1] && dfs(board, i, j - 1, vis, word.substring(1))) return true;
        if (i < board.length - 1 && !vis[i + 1][j] && dfs(board, i + 1, j, vis, word.substring(1))) return true;
        if (j < board[0].length - 1 && !vis[i][j + 1] && dfs(board, i, j + 1, vis, word.substring(1))) return true;
        vis[i][j] = false;
        return false;
    }

}
