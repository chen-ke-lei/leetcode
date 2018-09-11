package oj;

public class NumberOf1Between1AndNSolution {
	 public int NumberOf1Between1AndN_Solution(int n) {
		int sum=1;
		if(n==0||n==1)
			return n;
		for(int i=2;i<=n;i++) {
			sum=sum+getOneNums(i);
		}
		
		 return sum;
	    }
	 int getOneNums(int i) {
		 int num=0;
		 while(i>0) {
			 if(i%10==1)
				 num++;
			 i/=10;
		 }
		 return num;
		 
	 }

}
