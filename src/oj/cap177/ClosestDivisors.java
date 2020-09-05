package oj.cap177;

import java.util.Arrays;

public class ClosestDivisors {

public static void  main(String[] av){
    System.out.println(Arrays.toString(new ClosestDivisors().closestDivisors(688427155)));
}
    public int[] closestDivisors(int num) {
        int sub = num + 2;
        int[] res = new int[2];
        for (int i = 2; i <= Math.sqrt(num + 2); i++) {
            for (int j = i; j < num+2; j++) {
                if (j-i>sub||i * j > num + 2)
                    break;
                if ((i * j == num + 1 || i * j == num + 2) && j - i < sub) {
                    res[0] = i;
                    res[1] = j;
                    sub=j-i;
                }
            }
        }
        if (sub == num + 2) {
            res[0] = 1;
            res[1] = num + 1;
        }

        return res;
    }
}
