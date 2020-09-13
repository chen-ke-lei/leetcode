package oj;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
            boolean[] res =new boolean[s.length()+1];
            res[0]=true;
            for(int i=0;i<p.length();i++){
                char c=p.charAt(i);
                for(int j=s.length();j>=0;j--){
                    if(res[j]){
                        if(c=='*'){
                            for(int k=j;k<=s.length();k++)
                                res[k]=true;
                        }else if(c=='?'){
                            res[j]=false;
                            if(j<s.length()-1)
                                res[j+1]=true;
                        }else {
                            res[j]=false;
                            if(j<s.length()-1)
                                if(s.charAt(j)==c)
                                    res[j+1]=true;
                        }
                    }
                }
            }
            return res[res.length-1];
    }

    public static void main(String[] args) {
        new WildcardMatching().isMatch("adceb","*a*b");
    }
}
