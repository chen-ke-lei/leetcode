package oj.newcoder.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/// TODO: 2020/2/3  
public class  Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] sort = strs[i].toCharArray();
            Arrays.sort(sort);
            String tmp = new String(sort);
            if (map.containsKey(tmp)) {
                if (map.get(tmp) != null) {
                    res.add(map.get(tmp));
                    map.put(tmp, null);
                }
                res.add(strs[i]);
            } else {
                map.put(tmp, strs[i]);
            }
        }
        return res;
    }
}
