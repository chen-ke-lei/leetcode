package oj.swordtooffer;

public class Problem12 {
    public static void main(String[] av) {
        Problem12 problem12 = new Problem12();
        System.out.println(problem12.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] sign = new boolean[board.length][];
        for (int i = 0; i < sign.length; i++)
            sign[i] = new boolean[board[i].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {

                    if (dfs(board, sign, i, j, word, 0)) return true;
                }
            }
        }
        return false;

    }

    boolean dfs(char[][] board, boolean[][] sign, int i, int j, String word, int index) {
        if (word.charAt(index) != board[i][j]) return false;
        System.out.println(i+"   "+j+"   "+index);
        if (word.length() == index + 1) {
            return true;
        }
        sign[i][j] = true;
        if (i > 0 && !sign[i - 1][j] && dfs(board, sign, i - 1, j, word, index + 1)) return true;
        if (i < board.length - 1 && !sign[i + 1][j] && dfs(board, sign, i + 1, j, word, index + 1)) return true;
        if (j > 0 && !sign[i][j - 1] && dfs(board, sign, i, j - 1, word, index + 1)) return true;
        if (j < sign[i].length - 1 && !sign[i][j + 1] && dfs(board, sign, i, j + 1, word, index + 1)) return true;

        sign[i][j] = false;
        return false;
    }
}
