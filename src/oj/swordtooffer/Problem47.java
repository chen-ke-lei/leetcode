package oj.swordtooffer;

public class Problem47 {
    public int maxValue(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int[] sub = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0)
                    sub[j] = grid[i][j];
                int a = i > 0 ? sub[j] : 0;
                int b = j > 0 ?sub[j-1] : 0;
                a = a > b ? a : b;
                sub[j] = a+grid[i][j];
            }
        }
        return sub[sub.length - 1];
    }
}
