package oj.top100;

public class DecodeString {
    public String decodeString(String s) {
        StringBuffer buffer=new StringBuffer();
        int times=0;
        int stack=0;
        StringBuffer buffer1=null;
        for(char c:s.toCharArray()){
           if(stack==0){
               if(c=='['){
                   stack++;
                   buffer1=new StringBuffer();
               }else if(c>='0'&&c<='9'){
                   times=times*10+(c-'0');
               }else {
                   buffer.append(c);
               }
           }else {
               if(c==']'){
                   stack--;
                   if(stack==0){
                       String tmp=decodeString(buffer1.toString());
                       for(int i=0;i<times;i++){
                           buffer.append(tmp);
                       }
                       times=0;

                   }else {
                       buffer1.append(c);
                   }
               }else if(c=='['){
                   stack++;
                   buffer1.append(c);
               }else {
                   buffer1.append(c);
               }
           }
        }
        return buffer.toString();
    }
}
