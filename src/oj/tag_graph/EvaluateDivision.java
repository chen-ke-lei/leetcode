package oj.tag_graph;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res=new double[queries.size()];
        int index=0;
        Map<String ,Integer> var2Index=new HashMap<>();
        for(List<String> list:equations){
            for(String str:list){
                if(!var2Index.containsKey(str)){
                    var2Index.put(str,index++);
                }
            }
        }
        double[][] graph=new double[index][index];
        for(int i=0;i<equations.size();i++){
            graph[var2Index.get(equations.get(i).get(0))][var2Index.get(equations.get(i).get(1))]=values[i];
            graph[var2Index.get(equations.get(i).get(1))][var2Index.get(equations.get(i).get(0))]=(1/values[i]);
        }

        for(int i=0;i<index;i++)
            for(int j=0;j<index;j++)
                for(int k=0;k<index;k++){
                    if(i!=j&&j!=k&&i!=k){
                        if(graph[j][k]==0&&graph[j][i]!=0&&graph[i][k]!=0)
                            graph[j][k]=graph[j][i]*graph[i][k];
                    }
                }
        for(int k=0;k<queries.size();k++){
            List<String> list=queries.get(k);
            Integer i=var2Index.get(list.get(0)),j=var2Index.get(list.get(1));
            if(i!=null&&j!=null&&graph[i][j]!=0)res[k]=graph[i][j];
            else if(i!=null && j!=null && i.equals(j)) res[k]=1.0;
            else res[k]=-1.0;


        }
        return res;
    }
}
