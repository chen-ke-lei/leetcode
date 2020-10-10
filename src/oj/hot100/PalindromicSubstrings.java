package oj.hot100;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if(s.length()<=1)
            return s.length();
        int res=0;
        for(int i=0;i<s.length();i++){
            res++;
            int left=i-1,right=i+1;
            while (left>=0&&right<=s.length()-1){
                if(s.charAt(left)==s.charAt(right)){
                    res++;
                    left--;
                    right++;
                }else
                    break;
            }
            left=i;
            right=i+1;
            while (left>=0&&right<=s.length()-1){
                if(s.charAt(left)==s.charAt(right)){
                    res++;
                    left--;
                    right++;
                }else
                    break;
            }
        }

        return res;
    }
}
