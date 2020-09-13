package oj.interview.ctt.tx;

import java.util.Arrays;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] a = input.split("[ ]+");
        int n = Integer.valueOf(a[0]);
        int m = Integer.valueOf(a[1]);
        int time = Integer.valueOf(a[2]);
        int[][] weight = new int[n][n];
        for (int[] path : weight) {
            Arrays.fill(path, -1);
        }
        for (int i = 0; i < m; i++) {
            input = scanner.nextLine();
            a = input.split("[ ]+");
            weight[Integer.valueOf(a[0]) - 1][Integer.valueOf(a[1]) - 1] = Integer.valueOf(a[2]);
        }
        int[] path = Dijsktra(weight, 0);
        System.out.println(Arrays.toString(path));
        int res = path[path.length - 1];
        path = Dijsktra(weight, path.length - 1);
        res += path[0];
        System.out.println(res * time);

    }

    //-1认为不通
    public static int[] Dijsktra(int[][] weight, int start) {
        int length = weight.length;
        int[] shortPath = new int[length];
        boolean[] hasRes = new boolean[length];
        hasRes[start] = true;
        shortPath[start] = 0;
        for (int i = 0; i < length; i++) {
            int[] paths = weight[start];
            int w = shortPath[start];

            for (int j = 0; j < paths.length; j++) {
                if (hasRes[j] == true || paths[j] <= 0)
                    continue;
                int tmp = w + paths[j];
                if (shortPath[j] == 0 || shortPath[j] > tmp)
                    shortPath[j] = tmp;

            }
            int min = Integer.MAX_VALUE, site = 0;
            for (int j = 0; j < shortPath.length; j++) {
                if (hasRes[j] || shortPath[j] == 0)
                    continue;
                if (min > shortPath[j]) {
                    min = shortPath[j];
                    site = j;
                }
            }
            if (min != Integer.MAX_VALUE) {
                start = site;
                hasRes[site] = true;
            } else {
                break;
            }

        }
        return shortPath;

    }

}
