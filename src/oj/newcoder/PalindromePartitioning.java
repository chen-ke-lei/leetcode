package oj.newcoder;

import java.util.ArrayList;

public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        dfs(s, res, tmp);
        return res;
    }

    void dfs(String s, ArrayList<ArrayList<String>> res, ArrayList<String> tmp) {
        for (int i = 1; i <= s.length(); i++) {
            if (isPal(s.substring(0,i))) {
                tmp.add(s.substring(0,i));
                if (i < s.length()) {
                    dfs(s.substring(i),res,tmp);
                } else {
                    res.add(new ArrayList<>(tmp));
                }
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    boolean isPal(String s) {
        if (s.length() == 0 || s.length() == 1)
            return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
