package oj.hot200;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q734 {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        Set<String> set = new HashSet<>();
        for (List<String> similarPair : similarPairs) {
            set.add(similarPair.get(0) + "_" + similarPair.get(1));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (!sentence1[i].equals(sentence2[i]) && !set.contains(sentence1[i] + "_" + sentence2[i])
                    && !set.contains(sentence2[i] + "_" + sentence1[i])) return false;
        }
        return true;
    }
}
