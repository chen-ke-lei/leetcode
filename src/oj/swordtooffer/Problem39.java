package oj.swordtooffer;

public class Problem39 {
    public int majorityElement(int[] nums) {
        int tmp = 0;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (n == 0) {
                tmp = nums[i];
                n++;
            } else {
                if (nums[i] == tmp)
                    n++;
                else
                    n--;
            }
        }
        return tmp;
    }
}
