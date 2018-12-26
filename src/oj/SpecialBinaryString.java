package oj;

//TOOD 有点麻烦
public class SpecialBinaryString {
	public String makeLargestSpecial(String S) {
		String res = "";
		int i = S.length() - 1;
		int zoroNum = 0;
		int oneNum = 0;
		int subIndex=-1;
		int subLength=0;
		for (; i >= 0; i--) {
			if (S.charAt(i) == '0' && oneNum == 0) {
				zoroNum++;
			} else if (S.charAt(i) == '1' && oneNum <= zoroNum) {
				oneNum++;
			} else {
				if(subIndex==-1) {
					subIndex=1;
				}
			}

		}
		return S;
	}

}
