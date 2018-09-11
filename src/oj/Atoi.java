package oj;

public class Atoi {
	public static void main(String[] args) {
		System.out.println(new Atoi().myAtoi("-91283472332"));
	}
	//48-57  -45  32 
	 public int myAtoi(String str) {
		 str=str+" ";
		 int index=0;
		 int sign=1;
		 while(str.charAt(index)==' ')
			 index++;
		 if(str.charAt(index)=='-') {
			 index++;
			 sign=-1;
		 }
		 int res=0;
		 int num=0;
		 while((num=isContinue(str.charAt(index++)))>=0&&num<=9) {
			if(((res & 0x70000000)!=0)||(res=(res*10+num))<0) {
				if(sign>0)
					return 0x7fffffff;
				else
					return 0x80000000;
			}
			System.out.println(res);
		 }
		 return res*sign;
	 }
	 
	 int  isContinue(char c) {
		return c-48;
	 }

}
