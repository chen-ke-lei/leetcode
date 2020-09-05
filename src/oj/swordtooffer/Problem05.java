package oj.swordtooffer;

public class Problem05 {
    public String replaceSpace(String s) {
        String res="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')
                res+="%20";
            else
                res+=s.charAt(i);
        }
        return res;
    }
}
