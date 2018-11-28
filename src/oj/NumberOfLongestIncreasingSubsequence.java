package oj;

public class NumberOfLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int[][] resRecord = new int[nums.length][2];
		int maxRecord = 1;
		int maxNum = 1;
		// x0 代表长度 x1代表数量
		resRecord[0][0] = 1;
		resRecord[0][1] = 1;
		for (int i = 1; i < nums.length; i++) {
			int tmpMin = 0;
			int tmpRecord = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (resRecord[j][0] == tmpMin) {
						tmpRecord += resRecord[j][1];
					} else if (resRecord[j][0] > tmpMin) {
						tmpMin = resRecord[j][0];
						tmpRecord = resRecord[j][1];
					}
				}
			}
			resRecord[i][0] = tmpMin + 1;
			resRecord[i][1] = tmpRecord;
			if (tmpMin + 1 == maxRecord) {
				maxNum += tmpRecord;
			} else if (tmpMin + 1 > maxRecord) {
				maxRecord = tmpMin + 1;
				maxNum = tmpRecord;
			}
		}
		return maxNum;
	}
	public static void main(String[] args) {
		NumberOfLongestIncreasingSubsequence nolis=new NumberOfLongestIncreasingSubsequence();
		System.out.println(nolis.findNumberOfLIS(new int[] {1,3,5,4,7}));
	}
}
