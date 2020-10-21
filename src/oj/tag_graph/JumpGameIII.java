package oj.tag_graph;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];
       return dfs(arr, vis, start);



    }

    boolean dfs(int[] arr, boolean[] vis, int start) {
        if (vis[start])
            return false;
        if (arr[start] == 0)
            return true;
        vis[start] = true;
        int beg=start-arr[start];
        int end=start+arr[start];
        if(beg>=0&&dfs(arr,vis,beg)) return true;
        if(end<arr.length&&dfs(arr,vis,end)) return true;
        return false;
    }
}
