package oj.hot100;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length<=1)
            return 0;
        int res=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min)
                min=prices[i];
            else if(prices[i]>min)
                res=res>prices[i]-min?res:prices[i]-min;
        }

        return res;
    }
}
