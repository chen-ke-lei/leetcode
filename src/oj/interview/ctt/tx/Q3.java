package oj.interview.ctt.tx;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] a = input.split("[ ]+");
        int L = Integer.valueOf(a[0]);
        int d = Integer.valueOf(a[1]);
        double e = 0.0;
        int time = 0;
        while (L > d) {
            time++;
            e += time * (d / (L * 1.0));
            L -= d;
        }
        System.out.println(e);
    }
}
