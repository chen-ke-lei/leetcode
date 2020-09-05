package oj.interview.ctt.zte;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] a = input.split("[ ]+");
        if (a.length != 3)
            System.out.println(" ‰»Î”–ŒÛ");
        int number = Integer.valueOf(a[0]) - 1;
        int x = Integer.valueOf(a[1]);
        int y = Integer.valueOf(a[2]);

        System.out.println((number / 1.0) * ((y + x) / 2.0));
    }
}
