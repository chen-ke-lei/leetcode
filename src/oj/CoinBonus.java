package oj;

import java.util.ArrayList;
import java.util.List;

public class CoinBonus {
    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        long[] coinNums=new long[n];
        List<Integer> resList=new ArrayList<>();
        List<List<Integer>> rship=new ArrayList<>();
        for (int i=0;i<n;i++)
            rship.add(new ArrayList<>());
       for(int[] ship:leadership){
           rship.get(ship[0]-1).add(ship[1]-1);
           rship.get(ship[1]-1).add(0,ship[0]-1);
       }
    //    System.out.println(rship);
//       if(1==1)
//        return null;
       for(int[] op:operations){
           switch (op[0]){
               case 1:
                  push(rship,coinNums,op[1]-1,op[2]);
                   break;
               case 2:
                //   System.out.println("========");
                   Long pushNum=poll(rship,coinNums,op[1]-1,op[2]);
                   System.out.println("========");
                  // coinNums[op[1]-1]-=pushNum;
                   push(rship,coinNums,op[1]-1,pushNum);
                   break;
               case 3:
                   resList.add((int) (coinNums[(op[1]-1)]%1000000007));
                   break;
           }
       }
       int[] res=new int[resList.size()];
       for(int i=0;i<res.length;i++)
           res[i]=resList.get(i);
        return res;
    }

    void   push(List<List<Integer>> rship,long[] coinNums,int i,long num){
      while (i!=0){
          coinNums[i]+=num;
          coinNums[i]%=1000000007;
          i=rship.get(i).get(0);
      }
       coinNums[0]+=num;
        coinNums[i]%=1000000007;
    }
    Long poll(List<List<Integer>> rship,long[] coinNums,int i,long num){
        coinNums[i]+=num;
        List<Integer> ships=rship.get(i);
        int j=1;
        if(i==0)
            j=0;
//        System.out.println(ships.size()+"  "+i+"  "+j);
//        System.out.println(ships+"  "+i+"  "+j);
        for(;j<ships.size();j++){
            coinNums[i]+=poll(rship,coinNums,ships.get(j),num);
            coinNums[i]%=1000000007;
        }
        return coinNums[i];
    }

    public static void main(String[] args) {
        new CoinBonus().bonus(6,new int[][]{{1, 2}, {1, 6}, {2, 3}, {2, 5}, {1, 4}},
                new int[][]{{1, 1, 500}, {2, 2, 50}, {3, 1}, {2, 6, 15}, {3, 1}});
    }
}
