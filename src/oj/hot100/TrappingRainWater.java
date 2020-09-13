package oj.hot100;

import java.util.Stack;

public class TrappingRainWater {
    public int trap(int[] height) {
        int res=0;
        Stack<Integer> a=new Stack<>(),b=new Stack<>();
        for(int i=0;i<height.length;i++){

            if(a.isEmpty()&&height[i]!=0){
                a.push(height[i]);
            }else if(!a.isEmpty()) {
                if(height[i]<=a.peek()){
                    a.push(height[i]);
                } else {
                    int tmp=0;
                    while (!a.isEmpty()&&(tmp=a.peek())<height[i]){
                        b.push(a.pop());
                    }
                    if(a.isEmpty()){
                        while (!b.isEmpty())
                            res+=(tmp-b.pop());
                    }else {
                        while (!b.isEmpty()){
                            res+=(height[i]-b.pop());
                            a.push(height[i]);
                        }

                    }
                    a.push(height[i]);
                }
            }
        //    System.out.println(a+"  "+res);
        }
        return res;
    }

    public static void main(String[] args) {
       System.out.println( new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
