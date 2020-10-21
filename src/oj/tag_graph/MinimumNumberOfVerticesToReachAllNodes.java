package oj.tag_graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res=new ArrayList<>();
        int[] graph=new int[n];
        for(int i=0;i<edges.size();i++)
            graph[edges.get(i).get(1)]++;
        for(int i=0;i<graph.length;i++)
            if(graph[i]==0)
                res.add(i);
        return res;
    }
}
