package oj.top100;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuffer buffer=new StringBuffer();
        buffer.append("(");
        dfs(res,1,buffer,n);
        return res;
    }

    void dfs(List<String> res,int stack,StringBuffer buffer,int n){
        if(buffer.length()+1==n*2){
            buffer.append(")");
            res.add(buffer.toString());
            buffer.deleteCharAt(buffer.length()-1);
        }else {
            if(buffer.length()+stack<n*2){
                buffer.append("(");
                dfs(res,stack+1,buffer,n);
                buffer.deleteCharAt(buffer.length()-1);
                if(stack>0){
                    buffer.append(")");
                    dfs(res,stack-1,buffer,n);
                    buffer.deleteCharAt(buffer.length()-1);
                }

            }else {
                buffer.append(")");
                dfs(res,stack-1,buffer,n);
                buffer.deleteCharAt(buffer.length()-1);
            }
        }
    }
}
