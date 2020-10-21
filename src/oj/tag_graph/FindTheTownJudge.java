package oj.tag_graph;

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int res = -1;
        int[] in = new int[N], out = new int[N];
        for (int[] t : trust) {
            out[t[0] - 1]++;
            in[t[1] - 1]++;
        }
        for (int i = 0; i < N; i++) {
            if (out[i] == 0 && in[i] == N - 1) {
                if (res == -1)
                    res = i + 1;
                else
                    return -1;
            }
        }
        return -1;
    }
}
