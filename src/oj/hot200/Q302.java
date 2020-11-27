package oj.hot200;

public class Q302 {
    int xMax, xMin, yMax, yMin;

    public int minArea(char[][] image, int x, int y) {
        boolean[][] vis = new boolean[image.length][image[x].length];
        xMax = x;
        xMin = x;
        yMax = y;
        yMin = y;
        dfs(image,vis,x,y);
        return (xMax - xMin + 1) * (yMax - yMin + 1);
    }

    void dfs(char[][] image, boolean[][] vis, int x, int y) {

        vis[x][y] = true;
        xMin = xMin < x ? xMin : x;
        xMax = xMax > x ? xMax : x;
        yMin = yMin < x ? yMin : x;
        yMax = yMax > x ? yMax : y;
        if (x > 0 && !vis[x - 1][y] && image[x - 1][y] == '1') dfs(image, vis, x - 1, y);
        if (y > 0 && !vis[x][y - 1] && image[x][y] == '1') dfs(image, vis, x, y + 1);
        if (x < vis.length - 1 && !vis[x + 1][y] && image[x + 1][y] == '1') dfs(image, vis, x + 1, y);
        if (y < vis[x].length - 1 && !vis[x][y + 1] && image[x][y + 1] == '1') dfs(image, vis, x, y + 1);

    }
}
