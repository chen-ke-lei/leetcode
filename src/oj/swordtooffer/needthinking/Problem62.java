package oj.swordtooffer.needthinking;

public class Problem62 {
    public static void main(String[] ag) {
        System.out.println(new Problem62().lastRemaining(70866,116922));
    }

    public int lastRemaining(int n, int m) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i;
        int length = n, fast = 0, slow = 0, index = 0;
        while (length > 1) {
            index++;
            if (index == m) {
                fast++;
                index = 0;
            } else {
                fast++;
                slow++;
            }
            if (fast == length) {
                length = slow;
                fast = 0;
                slow = 0;
            } else
                nums[slow] = nums[fast];

        }
        return nums[0];
    }
}
