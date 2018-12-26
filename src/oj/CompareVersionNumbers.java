package oj;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int v1length = v1.length;
		int v2length = v2.length;
		for (int i = v1length; i > 0; i--) {
			if (v1[i-1].matches("^0+$"))
				v1length--;
			else
				break;
		}
		for (int i = v2length; i > 0; i--) {
			if (v2[i-1].matches("^0+$"))
				v2length--;
			else
				break;
		}
		int minLength = Math.min(v1length, v2length);
		for (int i = 0; i < minLength; i++) {
			int v1Num = Integer.valueOf(v1[i]);
			int v2Num = Integer.valueOf(v2[i]);
			if (v1Num > v2Num)
				return 1;
			if (v1Num < v2Num)
				return -1;
		}
		if (v1length == v2length)
			return 0;
		return v1length > v2length ? 1 : -1;
	}

	public static void main(String[] args) {
		System.out.println(new CompareVersionNumbers().compareVersion("09.0", "9"));
	}
}
