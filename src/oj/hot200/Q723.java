package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q723 {
    public int[][] candyCrush(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return board;
        List<int[]> pre = new ArrayList<>();
        do {
            //«Âø’
            for (int[] ints : pre) {
                board[ints[0]][ints[1]] = 0;
            }
            pre = new ArrayList<>();
            //œ¬¬‰
            for (int i = 0; i < board[0].length; i++) {
                int zeroNum = 0;
                for (int j = board.length - 1; j >= 0; j--) {
                    if (board[j][i] == 0) {
                        zeroNum++;
                    } else {
                        int tmp = board[j][i];
                        board[j][i] = 0;
                        board[j + zeroNum][i] = tmp;
                    }
                }
            }
            //∫·≈≈
            for (int i = 0; i < board.length; i++) {
                int last = 0;
                int length = 0;
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 0) {
                        if (length >= 3) {
                            for (int k = 0; k < length; k++) {
                                pre.add(new int[]{i, j - k});
                            }
                        }
                        last = 0;
                        length = 0;
                    } else if (last == board[i][j]) length++;
                    else {
                        if (length >= 3) {
                            for (int k = 0; k < length; k++) {
                                pre.add(new int[]{i, j - k});
                            }
                        }
                        last = board[i][j];
                        length = 1;
                    }
                }
                if (length >= 3) {
                    for (int k = 0; k < length; k++) {
                        pre.add(new int[]{i, board[i].length - k - 1});
                    }
                }
            }
            // ˙≈≈
            for (int i = 0; i < board[0].length; i++) {
                int last = 0;
                int length = 0;
                for (int j = 0; j < board.length; j++) {
                    if (board[j][i] == 0) {
                        if (length >= 3) {
                            for (int k = 0; k < length; k++) {
                                pre.add(new int[]{j - k, i});
                            }
                        }
                        last = 0;
                        length = 0;
                    } else if (last == (board[j][i])) length++;
                    else {
                        if (length >= 3) {
                            for (int k = 0; k < length; k++) {
                                pre.add(new int[]{j - k, i});
                            }
                        }
                        last = board[j][i];
                        length = 1;
                    }
                }
                if (length >= 3) {
                    for (int k = 0; k < length; k++) {
                        pre.add(new int[]{board.length - 1 - k, i});
                    }
                }
            }

        } while (!pre.isEmpty());

        return board;
    }
}
