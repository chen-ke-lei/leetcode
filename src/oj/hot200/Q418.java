package oj.hot200;

public class Q418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int res = 0;
        int pointer = 0;
        for (int i = 1; i <= rows; i++) {
            int num = cols;
            while (num > sentence[pointer].length()) {
                num -= sentence[pointer].length();
                num -= 1;
                pointer++;
                if (pointer == sentence.length) {
                    res++;
                    pointer = 0;
                }
            }
        }
        return res;
    }
}
