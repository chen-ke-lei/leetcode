package oj.hot200;

public class Q531 {
    public int findLonelyPixel(char[][] picture) {
        if (picture.length == 0 || picture[0].length == 0) return 0;
        int res = 0;
        int[] step = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            int alone = -1;
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] == 'B') {
                    if (alone == -1) {
                        alone = j;
                        step[j]++;
                    } else {
                        step[alone]++;
                        step[j] += 2;
                     //   break;
                    }
                }
            }
           // if (alone != -1) step[alone]++;
        }
        for (int i : step) {
            if (i == 1) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q531().findLonelyPixel(new char[][]{{'B', 'B', 'W', 'B', 'W', 'B', 'B', 'B', 'B', 'W'}, {'W', 'B', 'W', 'B', 'B', 'W', 'W', 'W', 'W', 'B'}, {'W', 'B', 'B', 'B', 'W', 'W', 'B', 'W', 'W', 'B'}, {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'B', 'W', 'W'}, {'W', 'B', 'B', 'W', 'W', 'W', 'B', 'B', 'W', 'B'}, {'B', 'B', 'B', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'W', 'W', 'B', 'B', 'B', 'W', 'B', 'W', 'W', 'B'}, {'B', 'W', 'W', 'B', 'B', 'W', 'W', 'W', 'W', 'W'}, {'B', 'W', 'B', 'W', 'W', 'B', 'W', 'B', 'B', 'W'}, {'B', 'B', 'B', 'B', 'W', 'W', 'W', 'B', 'B', 'W'}}));
    }
}
