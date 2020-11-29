package oj.hot200;

public class Q553 {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture.length == 0 || picture[0].length == 0) return 0;
        int res = 0;
        int[] x = new int[picture.length];
        int[] y = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            int num = 0;
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] == 'B') num++;
            }
            x[i] = num;
        }

        for (int i = 0; i < picture[0].length; i++) {
            int num = 0;
            for (int j = 0; j < picture.length; j++) {
                if (picture[j][i] == 'B') num++;
            }
            y[i] = num;
        }
        for (int i = 0; i < picture.length; i++)
            for (int j = 0; j < picture[i].length; j++)
                if (picture[i][j] == 'B' && x[i] == N && y[j] == N) res++;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q553().findBlackPixel(new char[][]{
                        {'W','B','W','B','B','W'},
                        {'B','W','B','W','W','B'},
                        {'W','B','W','B','B','W'},
                        {'B','W','B','W','W','B'},
                        {'W','W','W','B','B','W'},
                        {'B','W','B','W','W','B'}
                }
                ,3));
    }
}
