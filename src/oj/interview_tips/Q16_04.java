package oj.interview_tips;

public class Q16_04 {
    public String tictactoe(String[] board) {
        boolean space = false, x = false, y = false, win = false;
        int N = board.length;
        for (int i = 0; i < N; i++) {
            x = false;
            y = false;
            win = true;
            for (int j = 0; j < N; j++) {
                if (board[i].charAt(j) == ' ') {
                    space = true;
                    win = false;
                    break;
                } else if (board[i].charAt(j) == 'X') {
                    if (y) {
                        win = false;
                        break;
                    }
                    x = true;
                } else {
                    if (x) {
                        win = false;
                        break;
                    }
                    y = true;
                }
            }
            if (win) return x ? "X" : "O";
            x = false;
            y = false;
            win = true;
            for (int j = 0; j < N; j++) {
                char c = board[j].charAt(i);
                if (c == ' ') {
                    space = true;
                    win = false;
                    break;
                } else if (c == 'X') {
                    if (y) {
                        win = false;
                        break;
                    }
                    x = true;
                } else {
                    if (x) {
                        win = false;
                        break;
                    }
                    y = true;
                }
            }
        if (win) return x ? "X" : "O";
        }
        x = false;
        y = false;
        win = true;
        for (int i = 0; i < N; i++) {
            char c = board[i].charAt(i);
            if (c == ' ') {
                space = true;
                win = false;
                break;
            } else if (c == 'X') {
                if (y) {
                    win = false;
                    break;
                }
                x = true;
            } else {
                if (x) {
                    win = false;
                    break;
                }
                y = true;
            }
        }
        if (win) return x ? "X" : "O";

        x = false;
        y = false;
        win = true;
        for (int i = 0; i < N; i++) {
            char c = board[i].charAt(N - i - 1);
            if (c == ' ') {
                space = true;
                win = false;
                break;
            } else if (c == 'X') {
                if (y) {
                    win = false;
                    break;
                }
                x = true;
            } else {
                if (x) {
                    win = false;
                    break;
                }
                y = true;
            }
        }
        if (win) return x ? "X" : "O";
        return space ? "Pending" : "Draw";
    }

    public static void main(String[] args) {
        System.out.println(new Q16_04().tictactoe(new String[]{
                "O X"," XO","X O"
        }));
    }
}
