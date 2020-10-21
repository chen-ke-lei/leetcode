package oj.tag_graph;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        int[][] matrix=new int[n][n] ;
        for(int i=0;i<prerequisites.length;i++)
            matrix[prerequisites[i][0]][prerequisites[i][1]]=1;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                for(int k=0;k<n;k++){
                    if(matrix[j][k]==0&&matrix[j][i]!=0&&matrix[i][k]!=0)
                        matrix[j][k]=1;
                }
         for(int i=0;i<queries.length;i++){
             if(matrix[queries[i][0]][queries[i][1]]==1)
                 res.add(true);
             else res.add(false);
         }
        return res;
    }
}
