package oj.hot200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q760 {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] res = new int[A.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            if (!map.containsKey(B[i])) map.put(B[i], new ArrayList<>());
            map.get(B[i]).add(i);
        }
        for (int i = 0; i < A.length; i++) {
            res[i] = map.get(A[i]).get(map.get(A[i]).size() - 1);
            map.get(A[i]).remove(map.get(A[i]).size() - 1);
        }
        return res;
    }
}
