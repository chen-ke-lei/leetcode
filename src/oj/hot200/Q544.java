package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q544 {
    public String findContestMatch(int n) {
        List<String> pre = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            pre.add("(" + (i + 1) + "," + (n - i) + ")");
        }
        List<String> next = new ArrayList<>();
        while (pre.size() > 1) {
            for (int i = 0; i < pre.size() / 2; i++) {
                next.add("(" + pre.get(i) + "," + pre.get(pre.size() - i - 1) + ")");
            }
            pre = next;
            next = new ArrayList<>();
        }
        return pre.get(0);
    }
}
