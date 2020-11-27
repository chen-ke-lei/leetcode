package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q247 {
    public List<String> findStrobogrammatic(int n) {
        List<String> tmp = new ArrayList<>();
        char[] sign = new char[]{'1', '6', '8', '9','0'};
        dfs(tmp, new StringBuilder(), n / 2, sign);
        List<String> res = new ArrayList<>();
        for (String s : tmp) {
            StringBuilder builder = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == '6') c = '9';
                else if (c == '9') c = '6';
                builder.append(c);
            }
            if (n % 2 == 1) {
                res.add(s + '1' + builder.toString());
                res.add(s + '8' + builder.toString());
                res.add(s + '0' + builder.toString());
            } else {
                res.add(s + builder.toString());
            }
        }
        return res;
    }

    void dfs(List<String> res, StringBuilder stringBuilder, int n, char[] sign) {
        if (n == 0) {
            res.add(stringBuilder.toString());
            return;
        }
        for (char c : sign) {
            if(c=='0'&&stringBuilder.length()==0)continue;
            stringBuilder.append(c);
            dfs(res, stringBuilder, n - 1, sign);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
