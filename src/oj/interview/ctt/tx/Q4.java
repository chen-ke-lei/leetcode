package oj.interview.ctt.tx;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int T = Integer.valueOf(input);
        List<String> res = new ArrayList<>();
        outer:
        for (int i = 0; i < T; i++) {
            input = scanner.nextLine();
            int N = Integer.valueOf(input);
            Set<String> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                input = scanner.nextLine();
                String[] a = input.split(" ");
                Arrays.sort(a);
                String tmp = Arrays.toString(a);
                if (set.contains(tmp)) {
                    res.add("YES");
                    continue outer;
                } else {
                    set.add(tmp);
                }
            }
            res.add("NO");
        }
        for (String str : res)
            System.out.println(str);
    }
}
