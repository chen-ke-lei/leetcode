package oj.newcoder.todo;

import java.util.Arrays;

// TODO: 2020/2/2
public class NextPermutation {
    public static void main(String[] av) {
        int[] test = new int[]{1, 3, 2};//132
        new NextPermutation().nextPermutation(test);
        System.out.print(Arrays.toString(test));
    }

    public void nextPermutation(int[] num) {
        if (num == null || num.length < 2)
            return;
        int tmp = num[num.length - 1];
        int left = 0;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < tmp) {
                int index = i + 2;
                System.out.println(i);
                System.out.println(index);
                boolean tran = false;
                for (; index < num.length; index++) {
                    if (num[index] >= num[i]) {
                        tran = true;
                        break;
                    }

                }
                if (tran)
                    index -= 1;
                //    System.out.println(index);
                if (index >= num.length)
                    break;
                int change = num[i];
                num[i] = num[index];
                num[index] = change;
                left = i + 1;
                break;
            }
            tmp = num[i];
        }
        //  System.out.println(index);
        int end = num.length - 1;
        while (left < end) {
            int change = num[left];
            num[left] = num[end];
            num[end] = change;
            left++;
            end--;
        }
    }
}
