package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BitwiseORsOfSubarrays {
	public static void main(String[] args) {
		System.out.println(new BitwiseORsOfSubarrays().subarrayBitwiseORs(new int[] {39,19,30,56,79,50,19,70,30}));
	}

	// too slow
	public int subarrayBitwiseORs_slow(int[] A) {
		Set<Integer> res = new HashSet<>(), tmp = new HashSet<>(), pre = new HashSet<>();
		Integer[] tmparray = new Integer[A.length + 1];
		for (int i = 0; i < A.length; i++) {
			tmparray[i] = A[i];
		}
		tmparray[A.length] = 0;
		while (tmparray.length > 1) {
			for (int i = 0; i < tmparray.length; i++) {
				if (tmp.contains(tmparray[i]))
					pre.add(tmparray[i]);
				tmp.add(tmparray[i]);
			}
			tmparray = (Integer[]) tmp.toArray(new Integer[pre.size()]);
			for (int i = 0; i < tmparray.length - 1; i++) {
				for (int j = i + 1; j < tmparray.length; j++)
					pre.add(tmparray[i] | tmparray[j]);
			}
			tmparray = (Integer[]) pre.toArray(new Integer[pre.size()]);
			res.addAll(pre);
			tmp = pre;
			pre = new HashSet<>();
		}

		return res.size();
	}

	public int subarrayBitwiseORs(int[] A) {
		if (A == null)
			return 0;
		Set<Integer> res = new HashSet<>();
		List<Integer> nums = new ArrayList<>();
		int allNums = 0;
		for (int i = 0; i < A.length; i++) {
			res.add(A[i]);
			if(i==0||nums.get(nums.size()-1)!=A[i])
			nums.add(A[i]);
			allNums |= A[i];
		}
		res.add(allNums);
		for (int i = 0; i < nums.size() - 1; i++) {
			int tmp = nums.get(i);
			for (int j = i + 1; j < nums.size(); j++) {
				tmp|=nums.get(j);
				if((j<nums.size()-1&&nums.get(j+1)==tmp) || tmp==allNums)
					break;
				res.add(tmp);
			}
		}
		return res.size();
	}
	public int subarrayBitwiseORs_Per(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        
        // initialize
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            seen.add(A[i]);
        }
        
        // join pairs [i] and [i+1]
        int end = n - 1;
        while (end >= 1) {
            for (int i = 0; i < end; i++) {
                A[i] |= A[i + 1];
            }
            
            // filter out consecutive duplicates in array and add [i] to the set
            int i = 0;
            seen.add(A[i]);
            int j = 1;
            while (j < end) {
                if (A[i] != A[j]) {
                    A[++i] = A[j];
                    seen.add(A[i]);
                }
                j++;
            }
            end = i;
        }
        
        return seen.size();
    }

}
