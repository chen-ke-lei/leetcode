package oj.interview_tips;

public class Q08_10 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sc][sr];
        if (newColor != oldColor) {
            dfs(image, sc, sr, newColor, oldColor);
        }
        return image;
    }

    void dfs(int[][] image, int i, int j, int newColor, int oldColor) {
        if (i < 0 || i >= image.length) return;
        if (j < 0 || j >= image[i].length) return;
        if (image[i][j] != oldColor) return;
        image[i][j] = newColor;
        dfs(image, i - 1, j, newColor, oldColor);
        dfs(image, i + 1, j, newColor, oldColor);
        dfs(image, i, j - 1, newColor, oldColor);
        dfs(image, i, j + 1, newColor, oldColor);

    }
}
