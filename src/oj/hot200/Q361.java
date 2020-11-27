package oj.hot200;

public class Q361 {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int max = 0;
        int[][] number = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int start = 0, tmp = 0;
            boolean space = false;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'E') {
                    tmp++;
                } else if (grid[i][j] == '0') {
                    space = true;
                } else if (grid[i][j] == 'W') {
                    if (tmp > 0 && space) {
                        for (int k = start; k < j; k++) {
                            number[i][k] += tmp;
                            max = max > number[i][k] ? max : number[i][k];
                        }

                    }
                    start = j + 1;
                    tmp = 0;
                    space = false;
                }
            }
            if (start < grid[i].length && tmp > 0 && space) {
                for (int j = start; j < grid[i].length; j++) {
                    number[i][j] += tmp;
                    max = max > number[i][j] ? max : number[i][j];
                }
            }
        }


        for (int j = 0; j < grid[0].length; j++) {
            int start = 0, tmp = 0;
            boolean space = false;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 'E') {
                    tmp++;
                } else if (grid[i][j] == '0') {
                    space = true;
                } else if (grid[i][j] == 'W') {
                    if (tmp > 0 && space) {
                        for (int k = start; k < i; k++) {
                            number[k][j] += tmp;
                            if (grid[k][j] == 'E') tmp--;
                            max = max > number[k][j] ? max : number[k][j];
                        }

                    }
                    start = i + 1;
                    tmp = 0;
                    space = false;
                }
            }
            if (start < grid.length && tmp > 0 && space) {
                for (int k = start; k < grid.length; k++) {
                    number[k][j] += tmp;
                    if (grid[k][j] == 'E') tmp--;
                    max = max > number[k][j] ? max : number[k][j];
                }
            }
        }
        return max;
    }
}
