package oj.tag_graph;

import java.util.HashMap;
import java.util.Map;

public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < row.length; i += 2) {
            if (Math.abs(row[i] - row[i + 1]) != 1||Math.max(row[i], row[i + 1])%2!=1) {
                map.put(row[i], i);
                map.put(row[i + 1], i + 1);
            }
        }

        while (map.size() > 0) {
            System.out.println(map);
            for (Integer i : map.keySet()) {
                int target = i % 2 == 0 ? i + 1 : i - 1;
                int targetIndex = map.get(i) % 2 == 0 ? map.get(i) + 1 : map.get(i) - 1;
                int num = row[targetIndex];
                int sub = map.get(target);
                map.put(num, sub);
                row[sub]=num;
                res++;
                map.remove(i);
                map.remove(target);

                int subTarget= sub % 2 == 0 ? sub + 1 : sub - 1;
                if(Math.abs(row[sub]-row[subTarget])==1 && Math.max(row[sub],row[subTarget])%2==1){
                    map.remove(row[sub]);
                    map.remove(row[subTarget]);
                }
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CouplesHoldingHands().minSwapsCouples(new int[]{11,5,10,13,4,1,3,7,8,6,12,9,0,2}));
    }
}
