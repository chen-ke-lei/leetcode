package oj.top100.review01;

public class Q11 {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            res = (right - left) * Math.min(height[left], height[right]) > res ?
                    (right - left) * Math.min(height[left], height[right]) : res;
            if (height[left] < height[right]) left++;
            else right--;
        }
        return res;
    }
}
