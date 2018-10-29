package oj;

public class ExpressiveWords {
	public int expressiveWords(String S, String[] words) {
		if (words == null || S == null || S.trim().length() == 0)
			return 0;
		int res = 0;
		for (String base : words)
			if (tranfer(S, base))
				res++;
		return res;
	}

	boolean tranfer(String S, String base) {
		if (base == null || S.length() < base.length())
			return false;
		int[] bitCan = new int[S.length() + 1]; 
		for(int i=0;i<bitCan.length;i++)
			bitCan[i]=-1;
		for (int i = 0; i < base.length(); i++) {
			for (int j = bitCan.length - 1; j > 0; j--) {
				if (bitCan[j-1] == i - 1 && S.charAt(j-1) == base.charAt(i)) {
					bitCan[j] = i;
					if (j <= bitCan.length - 3 && S.charAt(j ) == S.charAt(j -1)
							&& S.charAt(j + 1) == S.charAt(j-1)) {
						bitCan[j + 2] = i;
						for (int k = j + 3; k < bitCan.length; k++) {
							if (S.charAt(k-1) == S.charAt(j-1))
								bitCan[k] = i;
							else {
								break;
							}
						}
					}
				}
			}
		}
		//System.out.println(base+"   "+bitCan[S.length()]);
		return bitCan[S.length()] == base.length()-1;
	}
	public static void main(String[] args) {
		System.out.println(new ExpressiveWords().expressiveWords("nnnnnnzzzznnnnnnpppppfffff", new String[] {"nzznpf","nnzznnpff","nznpff","nnznnpf",
				"nnznpff","nzznppf","nzznpff","nnzznnppf"}));
	}
}
