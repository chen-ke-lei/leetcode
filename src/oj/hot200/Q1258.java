package oj.hot200;

import java.util.*;

public class Q1258 {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> synonym : synonyms) {
            for (String s : synonym) {
                map.put(s, synonym);
            }
        }
        List<String> res = new ArrayList<>();
        String[] words = text.split(" ");
        StringBuilder builder = new StringBuilder();
        dfs(map, 0, words, res, builder, text);
        return res;
    }

    void dfs(Map<String, List<String>> map, int i, String[] words, List<String> res, StringBuilder builder, String text) {
        if (i == words.length) {
            if (!builder.toString().equals(text))
                res.add(builder.toString());
            return;
        }
        if (!map.containsKey(words[i])) {
            if (builder.length() > 0) builder.append(" ");
            builder.append(words[i]);
            dfs(map, i + 1, words, res, builder, text);
            if (builder.indexOf(" ") == -1) builder = new StringBuilder();
            else builder.delete(builder.lastIndexOf(" "),builder.length());
            return;
        }
        List<String> list = map.get(words[i]);
        for (String s : list) {
            if (builder.length() > 0) builder.append(" ");
            builder.append(s);
            dfs(map, i + 1, words, res, builder, text);
            if (builder.indexOf(" ") == -1) builder = new StringBuilder();
            else builder.delete( builder.lastIndexOf(" "),builder.length());
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList(new String[]{"happy", "joy"}));
        lists.add(Arrays.asList(new String[]{"sad", "sorrow"}));
        lists.add(Arrays.asList(new String[]{"joy", "cheerful"}));

        System.out.println(new Q1258().generateSentences(lists, "I am happy today but was sad yesterday"));
    }
}
