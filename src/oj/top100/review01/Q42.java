package oj.top100.review01;

public class Q42 {
    public int trap(int[] height) {
        if (height.length <= 1) return 0;
        int res = 0;
        int start = 0;
        int num = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] >= num) {
                for (int j = start + 1; j < i; j++)
                    res += num - height[j];
                start = i;
                num = height[i];
            }
        }
        if (start < height.length - 1) {
            int end = height.length - 1;
            int endNum = height[height.length - 1];
            for (int i = height.length - 2; i >= start; i--) {
                if (height[i] >= endNum) {
                    for (int j = i + 1; j < end; j++)
                        res += endNum - height[j];
                    end = i;
                    endNum = height[i];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q42().trap(new int[]{4, 2, 3}));
    }
}
