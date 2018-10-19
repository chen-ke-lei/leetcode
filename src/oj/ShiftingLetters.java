package oj;

public class ShiftingLetters {
	public static void main(String[] args) {
		System.out.println(new ShiftingLetters().shiftingLetters("abc",new int[] {3,5,9}));
	}
	 public String shiftingLetters(String S, int[] shifts) {
		 int last=0;
		 String reString="";
	     for(int i=shifts.length-1;i>=0;i--) {
	    	 last=((last+shifts[i])-97)%26+97;
	    	 reString=(char)((last+S.charAt(i)-97)%26+97)+reString;
	     }
		 
		 return reString;
	    }
}
