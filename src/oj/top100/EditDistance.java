package oj.top100;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0)
            return 0;
        if(word1.length()==0)
            return word2.length();
        if(word2.length()==0)
            return word1.length();
        int[][] res=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<res[0].length;i++)
            res[0][i]=i;
        for(int i=0;i<res.length;i++)
            res[i][0]=i;
        for(int i=1;i<res.length;i++){
            for(int j=1;j<res[i].length;j++){
                int del=res[i-1][j]+1;
                int ins=res[i][j-1]+1;
                int tra=word1.charAt(i-1)==word2.charAt(j-1)?res[i-1][j-1]:(res[i-1][j-1]+1);
                res[i][j]=Math.min(Math.min(del,ins),tra);
            }
        }
        return res[word1.length()][word2.length()];
    }
}
