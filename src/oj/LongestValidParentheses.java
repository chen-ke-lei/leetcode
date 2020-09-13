package oj;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        System.out.println(s.length());
        int stack=0;
        int max=0;
        int end=0;
        int beg=0;
        int sub=0;
        int[] stacks=new int[s.length()];
        for(int i=0;i<s.length();i++){
            int tmp=max;
            if(i>=15)
            System.out.print(stack+",");
            char c=s.charAt(i);
            if(c=='('){
                stack++;
                stacks[i]=stack;
            }else if(c==')'){
               stack--;

               stacks[i]=stack;
               if(stack<0){
                   beg=i+1;
                   end=-1;
                   stack=0;
                   sub=0;
               }else if(stack==0){

                   if(end+1==beg){
                       max=max>(i-beg+1+sub)?max:(i-beg+1+sub);
                       sub+=(i-beg+1);
                       end=i;
                       beg=i+1;
                   }else {
                       max=max>(i-beg+1)?max:(i-beg+1);
                       sub=i-beg+1;
                       end=i;
                       beg=i+1;
                   }
               }else {
                   for(int j=beg;j<i;j++){
                       if(stacks[j]-stack==1){
                           max=max>(i-j+1)?max:(i-j+1);
                       }
                   }
               }
            }
         //   System.out.println(beg);
//            if(tmp!=max)
//                System.out.println(i-max+1+"  "+max);
        }
        return max;
    }

    public static void main(String[] args) {
        new LongestValidParentheses().longestValidParentheses("(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())");

        String s="((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())";
        int stack=0;
        System.out.println(s.length());
        for(int i=0;i<s.length();i++){
            System.out.print(stack+",");
            if(s.charAt(i)==')')
                stack--;
            else if(s.charAt(i)=='(')
                stack++;
            if(stack<0){
                System.out.println(s.substring(0,i+1)+"  "+i);
                break;
            }
        }
    }
}
