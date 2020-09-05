package oj.cap177;

public class LargestMultipleOfThree {
    public String largestMultipleOfThree(int[] digits) {
        int sum = 0;
        int[] nums = new int[10];
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
            nums[digits[i]]++;
        }
        sum %= 3;
        //直接相等的情况
        if (sum != 0) {
            for (int i = 0; i < nums.length; i++) {
                if (i % 3 == sum && nums[i] > 0) {
                    nums[i]--;
                    sum = 0;
                    break;
                }
            }
        }
        if(sum!=0){
            for (int i = 0; i < nums.length; i++) {
                if (i % 3 != sum&&i%3!=0 && nums[i] > 0) {
                    nums[i]--;
                    sum = (sum+3-(i%3))%3;
                    break;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (i % 3 == sum && nums[i] > 0) {
                    nums[i]--;
                    sum = 0;
                    break;
                }
            }
        }
        String str = "";
        if (sum == 0)
            for (int i = 9; i >= 0; i--) {
                if (str.length() == 0 && i == 0 && nums[i] > 0) {
                    str = "0";
                    break;

                }
                for (int j = 0; j < nums[i]; j++) {
                    str += i;
                }
            }
        return str;
    }
}
