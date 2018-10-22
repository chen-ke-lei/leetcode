package oj;

public class ReverseWordsInAString {
	public String reverseWords(String s) {
		s=s.trim();
		String[] words=s.split(" ");
		s="";
		for(int i=0;i<words.length;i++)
			s+=words[i]+" ";
		
		return s.length()>0?s.substring(0, s.length()-1):"";
	}
}
