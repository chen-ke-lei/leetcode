package oj.swordtooffer;

public class Problem58I {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
        String[] sub = s.split(" ");
        String res = "";
        for (int i = sub.length - 1; i >= 0; i--)
            res += (sub[i] + " ");
        return res.replaceAll("[ ]+"," ").trim();
    }
}
