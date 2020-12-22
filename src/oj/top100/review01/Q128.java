package oj.top100.review01;

import java.util.ArrayList;
import java.util.List;

public class Q128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        List<Integer>[] hash = new List[nums.length];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = new ArrayList<>();
        }
        int max = 1;
        for (int num : nums) {
            int i = num % hash.length;
            if (i < 0) i = hash.length + i;
            hash[i].add(num);
        }
        int start = -1;
        int startNum = 0;
        List<int[]> ones = new ArrayList<>();
        for (int i = 0; i < hash.length; i++) {
            List<Integer> hash1 = hash[i];
            if (hash1.isEmpty()) {
                if (start == 0) {
                    ones.add(new int[]{startNum, i - start});
                }
                if (start >= 0)
                    i = start - 1;
                start = -1;
            } else if (start == -1) {
                start = i;
                startNum = hash1.get(hash1.size() - 1);
                hash1.remove(hash1.size() - 1);
                max = Math.max(1, max);
            } else {
                boolean find = false;
                for (int j = 0; j < hash1.size(); j++) {
                    if (startNum + i - start == hash1.get(j)) {
                        find = true;
                        max = Math.max(i - start + 1, max);
                        hash1.remove(j);
                        break;
                    }
                }
                if (!find) {
                    if (start == 0) {
                        ones.add(new int[]{startNum, i - start});
                    }
                    i = start - 1;
                    start = -1;
                }
            }
        }
        if (start != -1 && start != 0) {
            int num = startNum + hash.length - start;
            int tmp = hash.length - start;
            for (int[] one : ones) {
                if (one[0] == num) {
                    tmp += one[1];
                    break;
                }

            }
            max = Math.max(tmp, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q128().longestConsecutive(new int[]{0, -1, 0}));
    }
}
