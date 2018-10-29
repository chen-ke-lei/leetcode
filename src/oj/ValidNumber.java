package oj;

public class ValidNumber {
	 public boolean isNumber(String s) {
		 if(s==null||s.trim().length()==0)
			 return false;
        s=s.trim();
		 boolean ispoint=false;
		 boolean isE=false;
		 boolean isNum=false;
		 if(s.charAt(0)>='0' &&s.charAt(0)<='9') {
			 isNum=true;
		 }else if (s.charAt(0)=='.') {
			ispoint=true;
		}else if(s.charAt(0)!='-'&&s.charAt(0)!='+') {
			 return false;
		 }
     
		 for(int i=1;i<s.length();i++) {
			 if(s.charAt(i)>='0' &&s.charAt(i)<='9') {
				 isNum=true;
			 }else if(s.charAt(i)=='.') {
				 if(ispoint ||isE)
					 return false;
//				 if(!isNum)
//					 return false;
				 ispoint=true;
			 }else if(s.charAt(i)=='E' ||s.charAt(i)=='e') {
				 if(isE||!isNum)
					 return false;
			//	 ispoint=false;
				 isE=true;
				 isNum=false;
			 }else if(s.charAt(i)=='-'||s.charAt(i)=='+') {
				 if(!isE||isNum)
					 return false;
					 
			 }else {
				return false;
			}
		 }
	        return isNum;
	        
	    }
}
