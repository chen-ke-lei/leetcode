package oj.cap210;

public class Q5535 {
    public int maxDepth(String s) {
        int max=0;
        int stack=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                stack++;
            }else if(c==')')
                stack--;
            max=max>stack?max:stack;
        }
        return max;
    }
}
