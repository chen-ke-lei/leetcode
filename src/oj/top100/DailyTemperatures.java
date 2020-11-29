package oj.top100;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if(T.length<=1)
            return  new int[T.length];
        int[] res=new int[T.length];
        Stack<Integer> num=new Stack<>(),index=new Stack<>();
        for(int i=T.length-1;i>=0;i--){
            while (!num.isEmpty()&&(num.peek() <= T[i]) ){
                num.pop();
                index.pop();

            }
            if(num.isEmpty()){
                res[i]=0;

            }else {
                res[i]=index.peek()-i;
            }
            num.push(T[i]);
            index.push(i);
        }
        return res;
    }
}
