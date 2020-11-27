package oj.hot200;

import java.util.ArrayList;
import java.util.List;

public class Q320 {
    public List<String> generateAbbreviations(String word) {
        if (word.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        res.add(word);
        for (int i = 1; i < word.length(); i++) {
            for (int j = 0; j + i <= word.length(); j++) {
                res.add(word.substring(0, j) + i + word.substring(j + i ));
            }
        }
        res.add(word.length() + "");
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Q320().generateAbbreviations("word"));
    }
}
