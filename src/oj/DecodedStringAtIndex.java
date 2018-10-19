package oj;

public class DecodedStringAtIndex {
	public String decodeAtIndex1(String S, int K) {
		String res = "";
	
		StringBuffer tmp = new StringBuffer();
		for (int i = 0; i < S.length(); i++) {

			if (S.charAt(i) <= '9' && S.charAt(i) >= '0') {
				int num = S.charAt(i) - '0';
				if (K <= num * tmp.length()) {
					return tmp.charAt((K - 1) % tmp.length()) + "";
				}
				String nowString = tmp.toString();
				for (int n = 0; n < num - 1; n++) {
					tmp.append(nowString);
				}
			} else {
				tmp.append(S.charAt(i));

				if (K == tmp.length())
					return S.charAt(i) + "";
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new DecodedStringAtIndex().decodeAtIndex("ajx37nyx97niysdrzice4petvcvmcgqn282zicpbx6okybw93vhk782unctdbgmcjmbqn25rorktmu5ig2qn2y4xagtru2nehmsp", 976159153));
	}

	public String decodeAtIndex(String S, int K) {
		int i = 0;
		long tmp = 0L;
		for (; i < S.length(); i++) {
			if (S.charAt(i) <= '9' && S.charAt(i) >= '0') {
				int times = S.charAt(i) - '0';
				if (tmp * times > K && K % tmp != 0)
					break;
				if (tmp * times == K || (tmp * times > K && K % tmp == 0)) {
					for (int k = i; k >= 0; k--) {
						if (S.charAt(k) > '9' || S.charAt(k) < '0')
							return S.charAt(k) + "";
					}
				}
				tmp = tmp * times;
				if(tmp>tmp*times) {
					
				}
			} else {
				tmp++;
				if (tmp == K)
					return S.charAt(i) + "";
			}
		}
		return decodeAtIndex(S.substring(0, i), (int)(K % tmp));

	}
}
