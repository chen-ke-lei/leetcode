package oj.hot100;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int s1 = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                s1 = i;
            }
        }
        if (s1 != -1) {
            int tmp = nums[s1];
            for (int i = nums.length - 1; i > s1; i--) {
                if (nums[i] > tmp) {
                    nums[s1] = nums[i];
                    nums[i] = tmp;
                    break;
                }

            }
        }

        s1++;
        System.out.println(Arrays.toString(nums)+"  "+s1);
        for (int i = 0; i < (nums.length - s1) / 2; i++) {
            int tmp = nums[i + s1];
            nums[i + s1] = nums[nums.length - i  - 1];
            nums[nums.length - i  - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3,2};
        new NextPermutation().nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
