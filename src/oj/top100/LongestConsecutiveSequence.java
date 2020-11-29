package oj.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int res = 0;
        int hash = nums.length * 2 + 1;
        List<Integer>[] hashArray = new List[hash];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++)
            min = min < nums[i] ? min : nums[i];
        if (min < 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] -= min;
            }
        }
        for (int i : nums) {
            if (hashArray[i % hash] == null) hashArray[i % hash] = new ArrayList<>();
            hashArray[i % hash].add(i);
        }
        int start = -1, begnum = -1;
        Map<Integer, Integer> tmp = new HashMap<>();
        for (int i = 0; i < hashArray.length; i++) {
            if (start == -1) {
                if (hashArray[i] == null) continue;
                else {
                    start = i;
                    begnum = hashArray[i].get(hashArray[i].size() - 1);
                    hashArray[i].remove(hashArray[i].size() - 1);
                    if (hashArray[i].isEmpty()) hashArray[i] = null;
                }
            } else {
                if (hashArray[i] == null) {
                    res = i - start > res ? i - start : res;
                    if (start == 0) {
                        tmp.put(begnum, i - start);
                    }
                    i = start - 1;
                    begnum = -1;
                    start = -1;
                } else {
                    int target = begnum + (i - start);
                    int j = 0;
                    for (; j < hashArray[i].size(); j++) {
                        if (hashArray[i].get(j) == target) {
                            break;
                        }
                    }
                    if (j < hashArray[i].size()) {
                        hashArray[i].remove(j);
                        if (hashArray[i].size() == 0) hashArray[i] = null;
                    } else {
                        res = res > i - start ? res : i - start;
                        if (start == 0) {
                            tmp.put(begnum, i - start);
                        }
                        i = start - 1;
                        begnum = -1;
                        start = -1;
                    }

                }
            }
        }
        if (start != -1) {
            int num = hashArray.length - start;
            if (tmp.containsKey(begnum + num)) ;
            num += tmp.get(begnum + num);
            res = res > num ? res : num;
        }

        return res;
    }
}
