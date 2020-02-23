package oj.newcoder;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String tmp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < tmp.length() && j < strs[i].length(); j++) {
                if (tmp.charAt(j) != strs[i].charAt(j))
                    break;
            }
            tmp=tmp.substring(0,j);
        }
        return tmp;
    }
}
