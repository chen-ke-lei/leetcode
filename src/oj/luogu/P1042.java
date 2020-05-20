package oj.luogu;

import java.util.Scanner;

public class P1042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();

        for (int j = 0; j < 2; j++) {
            int w = 0, l = 0;
            int num = 0;
            int line = j == 0 ? 11 : 21;
            outer:
            for (int i = 0; i < msg.length(); i++) {
                switch (msg.charAt(i)) {
                    case 'W':
                        w++;
                        break;
                    case 'L':
                        l++;
                        break;
                    default:
                        if (w > 0 || l > 0) {
                            System.out.println(w + ":" + l);
                            num++;
                        }

                        break outer;
                }
                if (w + l == line) {
                    num++;
                    System.out.println(w + ":" + l);
                    w = 0;
                    l = 0;
                }
            }
            if (w + l > 0 || num == 0) {
                System.out.println(w + ":" + l);
            }

            if (j == 0)
                System.out.println();
        }

    }
}
