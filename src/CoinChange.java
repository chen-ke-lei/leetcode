import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount <= 0)
			return 0;
		Set<Integer> pre = new HashSet<>(), next = new HashSet<>(), already = new HashSet<>();
		pre.add(0);
		int over = 0;
		int times = 0;
		while (over < coins.length) {
			over = 0;
			times++;
			for (int i = 0; i < coins.length; i++) {
				int tmpover = 0;
				for (Integer step : pre) {

					if (coins[i] + step == amount)
						return times;
					else if (coins[i] + step > amount) {
						tmpover++;
					} else {
						if (!already.contains(coins[i] + step)) {
							already.add(coins[i] + step);
							next.add(coins[i] + step);
						}
					}
				}
				if (tmpover == pre.size())
					over++;
			}
			pre = next;
			next = new HashSet<>();
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(new CoinChange().coinChange(new int[] {2}, 3));
	}
}

class Solution {
    int total;
    public int coinChange(int[] coins, int amount) {
        total = Integer.MAX_VALUE;
       if(amount == 0) return 0;
       Arrays.sort(coins);
       count(amount, coins.length-1, coins, 0);
	   return total == Integer.MAX_VALUE?-1:total;
        
        
    }
    void count(int amount, int index, int[] coins, int count){
        if(index < 0 || count >= total -1) return;
        int c = amount/coins[index];
        for(int i = c; i >=0; i--){
            int newCount = count + i;
            int rem = amount - i*coins[index];
            if(rem > 0 && newCount<total)
                count(rem, index - 1, coins, newCount);
            else if(newCount<total)
                total = newCount;
            else if(newCount>=total-1)
                break;
        }
      
    }
}
