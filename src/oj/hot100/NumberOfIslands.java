package oj.hot100;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid.length==0)
            return 0;
        int res=0;
        boolean[][] sub=new boolean[grid.length][grid[grid.length-1].length];
        for(int i=0;i<sub.length;i++){
            for(int j=0;j<sub[i].length;j++){
                if(grid[i][j]=='0')
                    sub[i][j]=true;
                else {
                    if(sub[i][j]==false){
                        res++;
                        dfs(grid,sub,i,j);
                    }

                }
            }
        }
        return res;
    }
    void dfs(char[][] grid,boolean[][] sub,int i,int j){
        sub[i][j]=true;
        if(grid[i][j]=='1'){
            if(i>0&&!sub[i-1][j])
                dfs(grid,sub,i-1,j);
            if(j>0&&!sub[i][j-1])
                dfs(grid,sub,i,j-1);
            if(i<grid.length-1&&!sub[i+1][j])
                dfs(grid,sub,i+1,j);
            if(j<grid[i].length-1&&!sub[i][j+1])
                dfs(grid,sub,i,j+1);

        }
    }
}
