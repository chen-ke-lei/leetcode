package oj;

import java.util.ArrayList;
import java.util.List;

public class StrongPasswordChecker {
	// 在可以不删除或者插入的情况下，应该是优先替换
	public int strongPasswordChecker(String s) {
		if (s == null || s.length() == 0)
			return 6;
		int res = 0;
		boolean hasNum = false;
		boolean hasMin = false;
		boolean hasMax = false;
		List<String> series = new ArrayList<>();
		int seriesSize = 1;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
				case 1:
					hasNum = true;
					break;
				case 2:
					hasMin = true;
					break;
				case 3:
					hasMax = true;
					break;
				default:
					break;
			}
			if (i > 0) {
				if (c == s.charAt(i - 1)) {
					seriesSize++;
				} else {
					if (seriesSize >= 3) {
						series.add(s.substring(i - seriesSize + 1, i + 1));
						seriesSize = 1;
					}
				}
			}
		}
		if (series.isEmpty() && hasMax && hasMin && hasNum && s.length() >= 6 && s.length() <= 20)
			return 0;
		int loseType = 0;
		if (!hasMax)
			loseType++;
		if (!hasMin)
			loseType++;
		if (!hasNum)
			loseType++;
		if (s.length() >= 6 && s.length() <= 20) {
			int replaceNume = 0;
			for (String str : series) {
				replaceNume += str.length() / 3;
				
			}
			return Math.max(loseType, replaceNume);
		}
		if (s.length() < 6) {
			int insertlth = Math.max(loseType, 6 - s.length());
			return insertlth;
		}
		int deleteLth=s.length()-20;
		//int neededsize=deleteLth+loseT
		//替换 x  删除 y   x=(a-y)/3   min(Ex+Ey)  Ex>=loseType  deleteLth<=Ey<=deleteLth-12
		int res1num=0;
		int res2num=0;
		int replaceNum=0;
		for(String str:series) {
			replaceNum += str.length() / 3;
			if(str.length()%3==1)
				res1num++;
			if(str.length()%3==2)
				res2num++;
		}
		if(replaceNum<=loseType)
			return loseType+deleteLth;
		int trueDelete=0;
		
		return replaceNum+deleteLth;
	}

	int mode(char c) {
		if (c >= '0' && c <= '9')
			return 1;
		if (c >= 'a' && c <= 'z')
			return 2;
		if (c >= 'A' && c <= 'Z')
			return 3;
		return 0;
	}
}
