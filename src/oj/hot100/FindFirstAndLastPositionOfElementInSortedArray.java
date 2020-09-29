package oj.hot100;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target)
            return new int[]{-1, -1};
        int[] res = new int[2];
        int start = -1, end = -1;
        if (nums[0] == target)
            start = 0;

        if (nums[nums.length - 1] == target)
            end = nums.length - 1;
        if (start == -1 || end == -1) {
            int left = 0, right = nums.length - 1, tmp = -1;
            while (left <= right) {
                if (nums[left] == target) {
                    tmp = left;
                    break;
                }
                if (nums[right] == target) {
                    tmp = right;
                    break;
                }
                if (nums[(left + right) / 2] == target) {
                    tmp = (left + right) / 2;
                    break;
                } else if (nums[(left + right) / 2] < target) {
                    left = (left + right) / 2 + 1;
                } else {
                    right = (left + right) / 2 - 1;
                }

            }
            if (tmp != -1) {
                if (start == -1) {
                    start = 0;
                    right = tmp;
                    while (start <= right) {
                        if (nums[start] == target) {
                            start--;
                            break;
                        }
                        if (nums[right] < target) {
                            start = right;
                            break;
                        }
                        if (nums[(start + right) / 2] == target) {
                            right = (start + right) / 2 - 1;
                        } else {
                            start = (start + right) / 2 + 1;
                        }
                    }
                    start += 1;

                }
                if (end == -1) {
                    end = nums.length - 1;
                    left = tmp;
                    while (left <= end) {
                        if (nums[end] == target) {
                            end++;
                            break;
                        }
                        if (nums[left] > target) {
                            end = left;
                            break;
                        }

                        if (nums[(end + left) / 2] == target) {
                            left = (end + left) / 2 + 1;
                        } else {
                            end = (end + left) / 2 - 1;
                        }
                    }
                    end--;
                }
            }


        }
        res[0] = start;
        res[1] = end;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().
                searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
