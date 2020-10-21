package oj.cap210;

import java.util.Arrays;

public class Q5538 {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int res[] = new int[n - 1];
        int[][] m = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                m[i][j]=i==j?0:n+3;
        for (int i = 0; i < edges.length; i++) {
            m[edges[i][0]-1][edges[i][1]-1] = 1;
            m[edges[i][1]-1][edges[i][0]-1] = 1;
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                for(int k=0;k<n;k++){
                    if(i!=j&&i!=k&&j!=k)
                        if(m[j][k]>(m[j][i]+m[i][k])){
                            m[j][k]=m[j][i]+m[i][k];
                            res[m[j][k]-1]++;
                    }

                }

        for(int i=0;i<n;i++)
            System.out.println(Arrays.toString(m[i]));
        res[0]=edges.length;
        return res;
    }

    public static void main(String[] args) {
       int res[]= new Q5538().countSubgraphsForEachDiameter(4,new int[][]{{1,2},{2,3},{2,4}});
       System.out.println(Arrays.toString(res));
    }
}
