package oj.hot100;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(i==0&&j==0)
                    continue;

                int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
                if(i>0){
                    a=grid[i-1][j];
                }
                if(j>0)
                    b=grid[i][j-1];

                grid[i][j]+=Math.min(a,b);

            }
        }
        return grid[grid.length-1][grid[grid.length-1].length-1];
    }
}
