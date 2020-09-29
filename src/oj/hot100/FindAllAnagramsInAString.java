package oj.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> times = new HashMap<>();
        for (char c : p.toCharArray()) {
            if (!times.containsKey(c)) {
                times.put(c, 0);
            }
            times.put(c, times.get(c) + 1);
        }
        Map<Character,List<Integer>> index=new HashMap<>();
        for(char c:p.toCharArray())
            index.put(c,new ArrayList<>());
        System.out.println(times);
        System.out.println(index);
        int last = p.length(), beg = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!index.containsKey(c)){
                beg=i+1;
                last=p.length();
                continue;
            }
            if(index.get(c).size()<times.get(c)){
                last--;
            }else if(index.get(c).get(index.get(c).size()-times.get(c))<beg){
                last--;
            }else {
                beg=index.get(c).get(index.get(c).size()-times.get(c))+1;
                last=p.length()-(i-beg+1);
            }
            if(last==0){
                res.add(beg);
                last=1;
                beg+=1;
            }

            index.get(c).add(i);
        }

        return res;
    }

    public static void main(String[] args) {
       System.out.print(new  FindAllAnagramsInAString().findAnagrams("baa","aa"));
    }
}
