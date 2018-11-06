package oj;

public class NextGreaterElementIII {
	public int nextGreaterElement(int n) {
		if(n<10)
			return n;
		char[] digits = (n + "").toCharArray();
		for (int i = digits.length - 1; i > 0; i--) {
			if(digits[i]>digits[i-1]) {
				for(int j=digits.length-1;j>=i;j--) {
					if(digits[j]>digits[i-1]) {
						char tmp=digits[j];
						digits[j]=digits[i-1];
						digits[i-1]=tmp;
						break;
					}
				}
				for(int j=0;j<(digits.length-i)/2;j++) {
					char tmp=digits[j+i];
					digits[j+i]=digits[digits.length-1-j];
					digits[digits.length-1-j]=tmp;
				}
				Long res=Long.valueOf(new String(digits));
				if(res>Integer.MAX_VALUE)
					return -1;
				return Integer.valueOf(new String(digits));
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		NextGreaterElementIII nextGreaterElementIII=new NextGreaterElementIII();
		System.out.println(nextGreaterElementIII.nextGreaterElement(1999999999));
	}
}
