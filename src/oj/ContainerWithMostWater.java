package oj;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int maxHigh = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int sub = 0;
            if (height[i] > maxHigh)
                maxHigh = height[i];
            else
                continue;
            for (int j = i + 1; j < height.length; j++) {
                int num = height[i] > height[j] ? height[j] : height[i];
                sub = sub > (j - i) * num ? sub : (j - i) * num;
            }
            max = max > sub ? max : sub;
        }
        return max;
    }



    public int maxArea1(int[] height) {
        int maxArea = 0, l = 0, r = height.length -1;
        while (r > l) {
            int minHeight = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, minHeight * (r - l));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
            if (minHeight >= height[l]) {
                l++;
                continue;
            }
            if (minHeight >= height[r]) {
                r--;
                continue;
            }
        }
        return maxArea;
    }
}
