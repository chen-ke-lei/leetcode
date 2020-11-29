package oj.hot200;

public class Q557 {
    public int maxRepeating(String sequence, String word) {
        if (word.length() > sequence.length() || word.length() == 0) return 0;
        int dp[] = new int[sequence.length()+1];
        int res = 0;
        for (int i = word.length() ; i <dp.length; i++) {
            if (sequence.substring(i - word.length() , i ).equals(word))
                dp[i] =1+ dp[i - word.length() + 1];
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }
}
