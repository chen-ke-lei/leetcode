package oj.hot200;

public class Q245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int lenA = -1, lenB = -1;
        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                if (word1.equals(word2)) {
                    if (lenA == -1) lenA = i;
                    else if (lenB == -1) lenB = i;
                    else {
                        lenA = lenB;
                        lenB = i;
                    }
                } else {
                    lenA = i;
                }
            } else if (word2.equals(words[i])) {
                lenB = i;
            }
            if (lenA != -1 && lenB != -1) {
                min = min < Math.abs(lenA - lenB) ? min : Math.abs(lenA - lenB);
            }
        }
        return min;
    }
}
