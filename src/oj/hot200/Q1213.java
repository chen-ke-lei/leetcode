package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q1213 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                res.add(arr1[i]);
                i++;
                j++;
                k++;
            } else {
                int min = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
                if (min == arr1[i]) i++;
                if (min == arr2[j]) j++;
                if (min == arr3[k]) k++;
            }
        }
        return res;
    }
}
