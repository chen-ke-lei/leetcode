package oj.hot200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q244 {
    static class WordDistance {
        Map<String, List<Integer>> indexMap = new HashMap<>();

        public WordDistance(String[] words) {
            for (int i = 0; i < words.length; i++) {
                if (!indexMap.containsKey(words[i]))
                    indexMap.put(words[i], new ArrayList<>());
                indexMap.get(words[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = indexMap.get(word1), list2 = indexMap.get(word2);
            int i = 0, j = 0;
            int min = Math.abs(list1.get(0) - list2.get(0));
            while (i < list1.size() && j < list2.size()) {
                min = min > Math.abs(list1.get(i) - list2.get(j)) ? Math.abs(list1.get(i) - list2.get(j)) : min;
                if (i == list1.size() - 1) j++;
                else if (j == list2.size() - 1) i++;
                else if (list1.get(i) < list2.get(j)) i++;
                else j++;
            }
            return min;
        }

        public static void main(String[] args) {
            WordDistance wordDistance = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
            System.out.println(wordDistance.shortest("makes","coding"));
        }
    }
}
