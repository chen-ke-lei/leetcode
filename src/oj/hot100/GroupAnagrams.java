package oj.hot100;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        Map<String,List<String>> tmp=new HashMap<>();
        for(String str:strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String order=new String(chars);
            if(!tmp.containsKey(order))
                tmp.put(order,new ArrayList<>());
            tmp.get(order).add(str);
        }
        for(String str:tmp.keySet()){
            res.add(tmp.get(str));
        }
        return res;
    }
}
