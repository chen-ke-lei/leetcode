package oj;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> tmp = new HashSet<>(), res = new HashSet<>();
        for (int i : nums1) {
            tmp.add(i);
        }
        for (int i : nums2) {
            if (tmp.contains(i))
                res.add(i);
        }
        int[] arr = new int[res.size()];
        int i = 0;
        for (Integer re : res) {
            arr[i] = re;
            i++;
        }
        return arr;
    }
}
