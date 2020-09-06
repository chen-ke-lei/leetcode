package oj.interview.ctt.bytedance;


import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] a = input.split("[ ]+");
        int N = Integer.valueOf(a[0]), M = Integer.valueOf(a[1]);
        input = scanner.nextLine();
        a = input.split("[ ]+");
        int[] nums = new int[N];
        nums[0] = Integer.valueOf(a[0]);
        long max = Integer.valueOf(a[0]);
        long tmp = Integer.valueOf(a[0]);
        long sum = nums[0];
        int beg = 0;
        for (int i = 1; i < N; i++) {
            nums[i] = Integer.valueOf(a[i]);
            if (tmp < 0) {
                tmp = 0;
                beg = i;
            }
            sum += nums[i];
            tmp += nums[i];
            max = tmp > max ? tmp : max;
        }
        if (M == 1) {
            System.out.println(max);
        } else {
            if (sum <= 0) {
                for (int i = 0; i < N; i++) {
                    if (tmp < 0) {
                        tmp = 0;
                    }
                    tmp += nums[i];
                    max = tmp > max ? tmp : max;
                }
                System.out.println(max);
            } else {
                if (beg == 0) {
                    max = (sum * (M - 1) + max);
                } else {
                    tmp = sum * (M - 2);
                    max = tmp > max ? tmp : max;
                    for (int i = beg; i < N; i++) {
                        if (tmp < 0)
                            tmp = 0;
                        tmp += nums[i];
                        max = tmp > max ? tmp : max;
                    }
                    if(M>2){
                        for (int i = 0; i < N; i++) {
                            if (tmp < 0)
                                tmp = 0;
                            tmp += nums[i];
                            max = tmp > max ? tmp : max;
                        }
                    }
                }


                System.out.println(max);
            }

        }

    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        String[] a = input.split("[ ]+");
//        long N = Integer.valueOf(a[0]), M = Integer.valueOf(a[1]);
//        input = scanner.nextLine();
//        a = input.split("[ ]+");
//
//        long max = Integer.valueOf(a[0]);
//        long tmp = Integer.valueOf(a[0]);
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                if (j == 0 && i == 0)
//                    continue;
//                Integer.valueOf(a[i]);
//                if (tmp < 0) {
//                    tmp = 0;
//                }
//                tmp += Integer.valueOf(a[j]);
//                max = tmp > max ? tmp : max;
//            }
//        }
//        System.out.println(max);
//    }
}
