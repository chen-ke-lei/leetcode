package oj.hot200;

public class Q348 {
}

class TicTacToe {

    /**
     * Initialize your data structure here.
     */
    int[][] board;

    public TicTacToe(int n) {
        board = new int[n][n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        boolean win = true;
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != player) {
                win = false;
                break;
            }
        }
        if (win) return player;

        win = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != player) {
                win = false;
                break;
            }
        }
        if (win) return player;
        if (col == row) {
            win = true;
            for (int i = 0; i < board.length; i++) {
                if (board[i][i] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return player;
        }
        if (col + row == board.length - 1) {
            win = true;
            for (int i = 0; i < board.length; i++) {
                if (board[i][board.length - 1 - i] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return player;
        }
        return 0;
    }
}
