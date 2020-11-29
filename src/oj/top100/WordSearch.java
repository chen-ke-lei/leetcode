package oj.top100;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, new boolean[board.length][board[i].length], word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, boolean[][] site, String word, int index, int i, int j) {
       
        if (word.length() <= index)
            return true;
        if (board[i][j] != word.charAt(index)) return false;
        site[i][j] = true;
        if (i > 0 && !site[i - 1][j] && dfs(board, site, word, index + 1, i - 1, j)) return true;
        if (i < board.length - 1 && !site[i + 1][j] && dfs(board, site, word, index + 1, i + 1, j)) return true;
        if (j > 0 && !site[i][j - 1] && dfs(board, site, word, index + 1, i, j - 1)) return true;
        if (j < board[i].length - 1 && !site[i][j + 1] && dfs(board, site, word, index + 1, i, j + 1)) return true;
        site[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                "ABCB"));
    }
}
