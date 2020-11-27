package oj.hot200;

public class Q408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int index = 0;
        for (int i = 0; i < abbr.length(); i++) {
            if (index >= word.length()) return false;
            if (abbr.charAt(i) > '0' && abbr.charAt(i) <= '9') {
                int num = abbr.charAt(i) - '0';
                int j = i + 1;
                for (; j < abbr.length(); j++) {
                    if (abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                        num = num * 10 + abbr.charAt(j) - '0';
                    } else break;
                }
                index += num;
                i = j - 1;
            } else if (abbr.charAt(i) == word.charAt(index)) {
                index++;
            } else
                return false;

        }
        if (index != word.length()) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q408().validWordAbbreviation("internationalization"
                , "i12iz4n"));
    }
}
