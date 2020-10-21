package oj.tag_graph;

import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis=new boolean[rooms.size()];
        dfs(rooms,0,vis);
        for(boolean b:vis)
            if(!b) return false;
        return true;
    }

    void dfs(List<List<Integer>> rooms,int node,boolean[] vis){
        if(vis[node])
            return;
        vis[node]=true;
        for(int i=0;i<rooms.get(node).size();i++)
            dfs(rooms,rooms.get(node).get(i),vis);
    }
}
