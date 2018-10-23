package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class The3Sum {
	// 超时了
	public List<List<Integer>> threeSum_low(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		if (nums == null || nums.length < 3)
			return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			if (nums[i] > 0)
				break;
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				if (nums[i] + nums[j] > 0)
					break;
				for (int k = j + 1; k < nums.length; k++) {
					if (k > j + 1 && nums[k] == nums[k - 1])
						continue;
					if (nums[i] + nums[j] + nums[k] >= 0) {
						if (nums[i] + nums[k] + nums[j] == 0) {
							List<Integer> tmp = new ArrayList<>();
							tmp.add(nums[i]);
							tmp.add(nums[j]);
							tmp.add(nums[k]);
							res.add(tmp);
						}
						break;
					}
				}
			}
		}
		return res;
	}

	public List<List<Integer>> threeSum_ok(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		  if(nums==null||nums.length<3)
				return res;
		Map<Integer, Integer> numMap = new HashMap<>();
		int zeroNums = 0;
		for (int i = 0; i < nums.length; i++) {
			if (numMap.get(nums[i]) == null)
				numMap.put(nums[i], 0);
			if (nums[i] == 0)
				zeroNums++;
			numMap.put(nums[i], numMap.get(nums[i]) + 1);
		}
	
		if (zeroNums >= 3) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(0);
			tmp.add(0);
			tmp.add(0);
			res.add(tmp);
			System.out.println(tmp);
		}
		nums = new int[numMap.keySet().size()];
		int index = 0;
		for (Integer i : numMap.keySet()) {
			nums[index] = i;
			index++;
			if (i!=0&&numMap.get(i) > 1 &&  numMap.get(i * 2 * (-1)) != null) {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(i);
				tmp.add(i);
				tmp.add(i * 2 * (-1));
				res.add(tmp);
			}
		}
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		for (int i = 0; i < nums.length-1; i++) {
			if (nums[i] > 0)
				break;
			for (int j = i + 1; j < nums.length; j++) {
				int resNum = (nums[i] + nums[j])*(-1);
				if (resNum < 0)
					break;
				if (resNum>nums[j]&& numMap.get( resNum) != null) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(nums[i]);
					tmp.add(nums[j]);
					tmp.add(resNum);
					res.add(tmp);
					
				}

			}
		}

		return res;
	}
	public List<List<Integer>> threeSum(int[] nums) {
	      if (nums.length < 3)
	        return Collections.emptyList();
	      List<List<Integer>> res = new ArrayList<>();
	      int minValue = Integer.MAX_VALUE;
	      int maxValue = Integer.MIN_VALUE;
	      int negSize = 0;
	      int posSize = 0;
	      int zeroSize = 0;
	      for (int v : nums) {
	        if (v < minValue)
	          minValue = v;
	        if (v > maxValue)
	          maxValue = v;
	        if (v > 0)
	          posSize++;
	        else if (v < 0)
	          negSize++;
	        else
	          zeroSize++;
	      }
	      if (zeroSize >= 3)
	        res.add(Arrays.asList(0, 0, 0));
	      if (negSize == 0 || posSize == 0)
	        return res;
	      if (minValue * 2 + maxValue > 0)
	        maxValue = -minValue * 2;
	      else if (maxValue * 2 + minValue < 0)
	        minValue = -maxValue * 2;

	      int[] map = new int[maxValue - minValue + 1];
	      int[] negs = new int[negSize];
	      int[] poses = new int[posSize];
	      negSize = 0;
	      posSize = 0;
	      for (int v : nums) {
	        if (v >= minValue && v <= maxValue) {
	          if (map[v - minValue]++ == 0) {
	            if (v > 0)
	              poses[posSize++] = v;
	            else if (v < 0)
	              negs[negSize++] = v;
	          }
	        }
	      }
	      Arrays.sort(poses, 0, posSize);
	      Arrays.sort(negs, 0, negSize);
	      int basej = 0;
	      for (int i = negSize - 1; i >= 0; i--) {
	        int nv = negs[i];
	        int minp = (-nv) >>> 1;
	        while (basej < posSize && poses[basej] < minp)
	          basej++;
	        for (int j = basej; j < posSize; j++) {
	          int pv = poses[j];
	          int cv = 0 - nv - pv;
	          if (cv >= nv && cv <= pv) {
	            if (cv == nv) {
	              if (map[nv - minValue] > 1)
	                res.add(Arrays.asList(nv, nv, pv));
	            } else if (cv == pv) {
	              if (map[pv - minValue] > 1)
	                res.add(Arrays.asList(nv, pv, pv));
	            } else {
	              if (map[cv - minValue] > 0)
	                res.add(Arrays.asList(nv, cv, pv));
	            }
	          } else if (cv < nv)
	            break;
	        }
	      }
	      return res;
	    }
	public static void main(String[] args) {
		System.out.println(new The3Sum().threeSum(new int[] { 3,0,-2,-1,1,2 }));
	}
}
