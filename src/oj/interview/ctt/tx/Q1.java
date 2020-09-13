package oj.interview.ctt.tx;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int N = Integer.valueOf(input);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            scanner.nextLine();
            input = scanner.nextLine();
            String[] numStr = input.split(" ");
            Map<Integer, List<Integer>> tmp = new HashMap<>();
            int[] nums = new int[numStr.length];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = Integer.valueOf(numStr[j]);
                if (!tmp.containsKey(nums[j]))
                    tmp.put(nums[j], new ArrayList<>());
                tmp.get(nums[j]).add(j);
            }
            int max = 0;
            for (Integer num : tmp.keySet()) {
                if (tmp.get(num).size() < 2)
                    continue;
                List<Integer> tmpList = tmp.get(num);
                int[] left = new int[tmpList.size() - 1];
                int[] right = new int[tmpList.size() - 1];

                left[0] = findOrderMaxValue(nums, 0, tmpList.get(0));
                for (int k = 1; k < left.length; k++) {
                    left[k] = findOrderMaxValue(nums, tmpList.get(k - 1), tmpList.get(k));
                }
                right[right.length - 1] = findDisOrderMaxValue(nums, tmpList.get(tmpList.size() - 1), nums.length - 1);
                for (int k = 0; k < left.length - 1; k++) {
                    left[k] = findDisOrderMaxValue(nums, tmpList.get(k), tmpList.get(k + 1));
                }
                for (int k = 0; k < left.length; k++) {
                    for (int j = k; j < right.length; j++) {
                        max = Math.min(left[k], right[j]) > max ? Math.min(left[k], right[j]) : max;
                    }
                }

            }
            res.add(max);
        }
        for (Integer num : res)
            System.out.println(num*2);
    }

    static int findOrderMaxValue(int[] nums, int i, int j) {
        List<Integer> useNum = new ArrayList<>();
        for (; i < j; i++) {
            if (nums[i] > nums[j])
                useNum.add(nums[i]);
        }
        if (useNum.size() == 0)
            return 1;
        int[] tmp = new int[useNum.size()];
        tmp[tmp.length - 1] = 2;
        int max = 2;
        for (i = tmp.length - 2; i >= 0; i--) {
            tmp[i] = 2;
            for (j = i + 1; j < tmp.length; j++) {
                if (useNum.get(j) < useNum.get(i))
                    tmp[i] = tmp[i] > tmp[j] + 1 ? tmp[i] : tmp[j] + 1;
            }
            max = tmp[i] > max ? tmp[i] : max;
        }

        return max;
    }


    static int findDisOrderMaxValue(int[] nums, int i, int j) {
        List<Integer> useNum = new ArrayList<>();

        for (int k=i+1; k <= j; k++) {
            if (nums[i] < nums[k])
                useNum.add(nums[k]);
        }
        if (useNum.size() == 0)
            return 1;
        int[] tmp = new int[useNum.size()];
        tmp[0] = 2;
        int max = 2;
        for (i = 1; i < tmp.length; i++) {
            tmp[i] = 2;
            for (j = i - 1; j >= 0; j--) {
                if (useNum.get(j) < useNum.get(i))
                    tmp[i] = tmp[i] > (tmp[j] + 1) ? tmp[i] : tmp[j] + 1;
            }
            max = tmp[i] > max ? tmp[i] : max;
        }
        return max;
    }
}
