package oj.hot200;

import java.util.Arrays;

public class Q360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums.length == 0) return new int[0];
        if (nums.length == 1) return new int[cal(nums[0], a, b, c)];
        int start = 0;
        boolean reverse = false;
        if (a == 0) {
            if (b < 0) reverse = true;
        } else {
            if (a < 0) reverse = true;
            double mid = b / (a * (-2.0));
            if (nums[0] >= mid) start = 0;
            else if (nums[nums.length - 1] <= mid) start = nums.length - 1;
            else {
                int left = 0, right = nums.length - 1;
                while (left < right) {
                    int tmp = (right + left) / 2;
                    if (nums[tmp] == mid) {
                        start = tmp;
                        break;
                    } else if (nums[tmp] > mid) {
                        right = tmp;
                    } else {
                        left = tmp;
                    }
                    if (left + 1 == right) {
                        start = right;
                        break;
                    }
                }
            }
        }
        int[] res = new int[nums.length];

        int left = start - 1, right = start, index = 0;
        while (left >= 0 || right < nums.length) {
            if (left >= 0 && right < nums.length) {
                int leftNum = cal(nums[left], a, b, c);
                int rightNum = cal(nums[right], a, b, c);
                if (!reverse) {
                    res[index++] = Math.min(leftNum, rightNum);
                    if (leftNum < rightNum) left--;
                    else right++;
                } else {
                    res[res.length - 1 - index] = Math.max(leftNum, rightNum);
                    index++;
                    if (leftNum > rightNum) left--;
                    else right++;
                }
            } else if (left < 0) {
                if (!reverse) res[index++] = cal(nums[right], a, b, c);
                else res[res.length - 1 - index++] = cal(nums[right], a, b, c);
                right++;
            } else {
                if (!reverse) res[index++] = cal(nums[left], a, b, c);
                else res[res.length - 1 - index++] = cal(nums[left], a, b, c);
                left--;
            }

        }
        return res;
    }

    int cal(int num, int a, int b, int c) {
        long tmp = 1L * num * num * a + c + num * b;
        return (int) tmp;
    }

    public static void main(String[] args) {
        int[] tmp = new int[]{-99, -94, -90, -88, -84, -83, -79, -68, -58, -52, -52, -50, -47, -45, -35, -29, -5, -1, 9, 12, 13, 25, 27, 33, 36, 38, 40, 46, 47, 49, 57, 57, 61, 63, 73, 75, 79, 97, 98};
        System.out.println(Arrays.toString(new Q360().sortTransformedArray(tmp, -2, 44, -56)));
    }
}
