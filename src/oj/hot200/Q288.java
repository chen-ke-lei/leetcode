package oj.hot200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q288 {
    class ValidWordAbbr {
        Map<String, Set<String>> map;

        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<>();
            for (String s : dictionary) {
                String abbr;
                if (s.length() <= 2) abbr = s;
                else abbr = s.charAt(0) + "" + (s.length() - 2) + "" + s.charAt(s.length() - 1);
                if (!map.containsKey(abbr)) map.put(abbr, new HashSet<>());
                map.get(abbr).add(s);
            }
        }

        public boolean isUnique(String word) {
            String abbr;
            if (word.length() <= 2) abbr = word;
            else abbr = word.charAt(0) + "" + (word.length() - 2) + "" + word.charAt(word.length() - 1);
            if (!map.containsKey(abbr) || (map.get(abbr).size() == 1 && map.get(abbr).iterator().next().equals(word)))
                return true;
            return false;
        }
    }
}
