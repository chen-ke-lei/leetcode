package oj.newcoder;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String pre = "1", next = "";
        for (int i = 2; i <= n; i++) {
            char c = pre.charAt(0);
            int tmp = 1;
            for (int j = 1; j < pre.length(); j++) {
                if (pre.charAt(j) == c)
                    tmp++;
                else {
                    next = next + tmp + "" +c ;
                    tmp = 1;
                    c = pre.charAt(j);
                }
            }
            next = next + tmp + "" +c ;
            pre = next;
            next = "";
        }
        return pre;
    }
}
