package oj;

public class MaskingPersonalInformation {
	public String maskPII(String S) {
		String res = "";
		if (S.contains("@")) {
			S=S.toLowerCase();
			int index = S.indexOf('@');
			String begin = S.substring(0, index);
			String end = S.substring(index);
			res = begin.charAt(0) + "*****" + begin.charAt(begin.length() - 1) + end;
		} else {
			int length = 0;
			for (int i = 0; i < S.length(); i++) {
				char c = S.charAt(i);
				if (c >= '0' && c <= '9') {
					length++;
					res += c;
				}
			}
			res = res.substring(res.length() - 4);
			switch (length) {
				case 10:
					res = "***-***-" + res;
					break;
				case 11:
					res = "+*-***-***-" + res;
					break;
				case 12:
					res = "+**-***-***-" + res;
					break;
				case 13:
					res = "+***-***-***-" + res;
					break;
				default:
					break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "12345678";
		System.out.println(s.substring(s.length() - 4));
	}
}
