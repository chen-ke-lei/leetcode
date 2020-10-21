package oj.tag_graph;

import java.util.Arrays;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N][N];
        int[] path = new int[N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                graph[i][j] = -1;
        for (int i = 0; i < times.length; i++)
            graph[times[i][0] - 1][times[i][1] - 1] = times[i][2];
//        for (int i = 0; i < N; i++)
//            System.out.println(Arrays.toString(graph[i]));
        for (int i = 0; i < N; i++)
            path[i] = -1;
        path[K - 1] = 0;
        boolean[] view = new boolean[N];

        int start = K - 1;
        view[start] = true;
        while (true) {
            for (int i = 0; i < N; i++) {
                if (view[i]) continue;
                if (graph[start][i] >= 0) {
                    if (path[i] == -1)
                        path[i] = graph[start][i] + path[start];
                    else if (path[i] > graph[start][i] + path[start]) {
                        path[i] = graph[start][i] + path[start];
                    }
                }
            }
            int min = -1, index = -1;
            for (int i = 0; i < N; i++) {
                if (view[i] || path[i] == -1) continue;
                if (min == -1) {
                    min = path[i];
                    index = i;
                } else if (min > path[i]) {
                    min = path[i];
                    index = i;
                }
            }
            if (min == -1) break;
            else {
                view[index] = true;
                start = index;
            }
        }
        int res = -1;
        for (int i = 0; i < N; i++) {
            if (path[i] == -1) return -1;
            res = path[i] > res ? path[i] : res;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new NetworkDelayTime().networkDelayTime(new int[][]{{3, 5, 78}, {2, 1, 1},
                {1, 3, 0}, {4, 3, 59}, {5, 3, 85}, {5, 2, 22}, {2, 4, 23}, {1, 4, 43}, {4, 5, 75}, {5, 1, 15}
                , {1, 5, 91}, {4, 1, 16}, {3, 2, 98}
                , {3, 4, 22}, {5, 4, 31}, {1, 2, 0}, {2, 5, 4}, {4, 2, 51}, {3, 1, 36}, {2, 3, 59}}, 5, 5));
    }
}
