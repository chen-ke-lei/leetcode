package oj.hot200;

import java.util.*;

public class Q267 {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> c2I = new HashMap<>();
        int one = 0;
        for (char c : s.toCharArray()) {
            c2I.put(c, c2I.getOrDefault(c, 0) + 1);

            if (c2I.get(c) % 2 == 1) one++;
            else if (c2I.get(c) % 2 == 0) one--;
        }
        if (s.length() % 2 != one) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        String mid = "";
        List<Character> characters = new LinkedList<>();
        for (Character character : c2I.keySet()) {
            int time = c2I.get(character);
            if (time % 2 == 1) mid = character + "";
            time /= 2;
            for (int i = 0; i < time; i++)
                characters.add(character);
        }
        dfs(res, new StringBuilder(), characters);
        for (int j = 0; j < res.size(); j++) {
            String re = res.get(j);
            StringBuilder builder = new StringBuilder();
            builder.append(re);
            builder.append(mid);
            for (int i = re.length() - 1; i >= 0; i--)
                builder.append(re.charAt(i));
            res.set(j, builder.toString());
        }
        return res;
    }

    void dfs(List<String> res, StringBuilder builder, List<Character> tmp) {
        if (tmp.size() == 0) {
            res.add(builder.toString());
            return;
        }
        char last = '\0';
        for (int i = 0; i < tmp.size(); i++) {
            if (last == tmp.get(i)) continue;
            last = tmp.get(i);
            builder.append(tmp.get(i));
            tmp.remove(i);
            dfs(res, builder, tmp);
            tmp.add(i, last);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q267().generatePalindromes("aabb"));
        ;
    }
}
