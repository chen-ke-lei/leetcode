package oj.newcoder.todo;

// TODO: 2020/2/3
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null)
            return 0;
        if (word1 == null || word2 == null)
            return word1 == null ? word2.length() : word1.length();
        if (word2.equals(word2))
            return 0;
        int[] paths = new int[word2.length()];

        return paths[paths.length - 1];
    }
}
