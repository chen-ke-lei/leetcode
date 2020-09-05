package oj.tree;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || s.length() <= numRows || numRows == 1)
            return s;
        String res = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += (numRows * 2 - 2)) {
                res += s.charAt(j);
                if (i > 0 && i < numRows - 1 && j + numRows-i + numRows - i-2  < s.length()) {
                    res += s.charAt(j + numRows-i + numRows - i-2);

                }
            }
        }
        return res;
    }
}
