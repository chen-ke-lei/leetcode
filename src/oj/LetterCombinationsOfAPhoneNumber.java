package oj;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        dfs(res,digits,sb);
        return res;
    }

    void dfs(List<String> res, String digits, StringBuffer tmp) {
        if (digits.length() == 1) {
            String str = tran(digits.charAt(0));
            for (char c : str.toCharArray()) {
                res.add(tmp.toString() + c);
            }
            return;
        }

        String str = tran(digits.charAt(0));
        for (char c : str.toCharArray()) {
            tmp.append(c);
            dfs(res, digits.substring(1), tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    String tran(char c) {
        switch (c) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
        }
        return null;
    }
}
