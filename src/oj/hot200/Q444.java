package oj.hot200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        List<Integer> res = new ArrayList<>();
        int[] site = new int[org.length];
        int[][] graph = new int[org.length][org.length];
        for (List<Integer> seq : seqs) {
            for (int i = 1; i < seq.size(); i++) {
                graph[seq.get(i - 1) - 1][seq.get(i) - 1]++;
                site[seq.get(i) - 1]++;
            }
        }
        for (int j = 0; j < org.length; j++) {
            int index = -1;
            for (int i = 0; i < site.length; i++) {
                if (site[i] == 0) {
                    if (index == -1) index = i;
                    else return false;
                }
            }

            if (index == -1) return false;
            site[index] = -1;
            res.add(index + 1);
            for (int i = 0; i < org.length; i++) {
                if (graph[index][i] > 0) {
                    site[i]-=graph[index][i];
                    graph[index][i] = 0;

                }
            }
        }
        if (res.size() < org.length) return false;
        for (int i = 0; i < org.length; i++) {
            if (res.get(i) != org[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(new Integer[]{5,2,6,3}));
        seqs.add(Arrays.asList(new Integer[]{4,1,5,2}));


        System.out.println(new Q444().sequenceReconstruction(new int[]{4,1,5,2,6,3}, seqs));
    }
}
