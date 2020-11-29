package oj.top100;

import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set=new HashSet<>();
        List<List<String>> tmp=new ArrayList<>();
        int stact=0,beg=0;

        genVal(tmp,0,set,new StringBuffer());
        return new ArrayList<>(set);
    }

    void  genVal(List<List<String>> tmp,int i,Set<String> set,StringBuffer buffer){
        List<String> list=tmp.get(i);
        for(String s:list){
            buffer.append(s);
            if(i==tmp.size()-1)
                set.add(buffer.toString());
            else
                genVal(tmp,i+1,set,buffer);
            buffer.delete(buffer.length()-s.length(),buffer.length());
        }
    }
}
