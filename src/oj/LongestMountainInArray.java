package oj;

public class LongestMountainInArray {
	public int longestMountain(int[] A) {
		if (A.length < 3)
			return 0;
		int res = 0;
		int mode = 0;
		int tmp = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				if (mode == 2 || mode == 1) {
					tmp++;
					mode = 2;
				} else {
					mode = 0;
					tmp = 0;
				}
			} else if (A[i] > A[i - 1]) {
				if (mode == 1) {
					tmp++;
				} else {
					res = res > tmp ? res : tmp;
					tmp = 2;
					mode = 1;
				}
			} else {
				if(mode==2)
				res = res > tmp ? res : tmp;
				mode = 0;
				tmp = 0;
			}
			System.out.println(tmp+"   "+mode+" "+res);
		}
		return res < tmp  && mode==2 ? tmp : res;
	}

	 public int longestMountain_pre(int[] A){
	        if (A == null || A.length < 3) return 0;
	        int res = 0;
	        for (int i = 1; i < A.length-1; i++){
	            if (A[i-1] < A[i] && A[i+1] < A[i]){
	                int l = i - 1;
	                int r = i + 1;
	                while (l > 0 && A[l-1] < A[l]){
	                    l--;
	                }
	                while (r < A.length-1 && A[r+1] < A[r]){
	                    r++;
	                }
	                res = Math.max(res, (r-l+1));
	            }
	        }
	        return res;
	    }
	public static void main(String[] args) {
		System.out.println(new LongestMountainInArray().longestMountain(new int[] {0,2,2 }));
	}
}
