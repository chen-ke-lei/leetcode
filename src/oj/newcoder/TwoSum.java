package oj.newcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public  static void main(String[] av){
        System.out.print(Arrays.toString(new TwoSum().twoSum(new int[]{3,2,4},6)));
    }
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                if (numbers[i] * 2 == target) {
                    res[0] = map.get(numbers[i]);
                    res[1] = i+1;
                    return res;
                }
            } else
                map.put(numbers[i], i+1);
        }
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])&&i+1!=map.get(target-numbers[i])){
                res[0]=i+1;
                res[1]=map.get(target-numbers[i]);
                return res;
            }
        }
        return res;
    }
}
