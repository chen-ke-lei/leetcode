package oj.tag_graph;

public class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int lastIndex = -1;
            int num = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    num++;
                    lastIndex = j;
                }
            }
            if (num > 1) res += num;
            else if (num == 1) {
                num = 0;
                for (int j = 0; j < grid.length; j++) {
                    if (grid[j][lastIndex] == 1) num++;
                }
                if (num > 1) res++;
            }
        }
        return res;
    }
}
