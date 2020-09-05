package oj;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0)
            return true;
        if (s.length() != 0 && p.length() == 0)
            return false;
        List<String> tokens = new ArrayList<>();
        char last = p.charAt(0);
        if (last == '*')
            return false;
        for (int i = 1; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c != '*') {
                if(last!='\0')
                    tokens.add(last + "");
                last = c;
            } else {
                tokens.add(last + "" + c);
                last = '\0';
            }
        }
        if (last != '\0')
            tokens.add(last + "");
        System.out.println(tokens);
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (token.equals(".*")) {
                for (int j = 0; j < res.length; j++) {
                    if (res[j] == true) {
                        for (int k = j; k < res.length; k++)
                            res[k] = true;
                    }
                }
            } else if (token.equals(".")) {
                for (int j = res.length - 1; j >= 0; j--) {
                    if (res[j] == true) {
                        res[j] = false;
                        if (j < res.length - 1)
                            res[j + 1] = true;
                    }
                }
            } else if (token.endsWith("*")) {
                for (int j = res.length - 1; j >= 0; j--) {
                    if (res[j] == true) {
                        for (int k = j + 1; k < res.length; k++) {
                            if (token.startsWith(s.charAt(k - 1) + ""))
                                res[k] = true;
                            else
                                break;
                        }
                    }
                }
            } else {
                for (int j = res.length - 1; j >= 0; j--) {
                    if (res[j] == true) {
                        res[j] = false;
                        if (j < res.length - 1 && token.equals(s.charAt(j) + ""))
                            res[j + 1] = true;
                    }
                }
            }
        }
        return res[res.length - 1];
    }

    public static void main(String[] args) {
        new RegularExpressionMatching().isMatch("aab", "c*a*b");
    }
}
