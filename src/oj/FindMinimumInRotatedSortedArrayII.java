package oj;

public class FindMinimumInRotatedSortedArrayII {
	public int findMin(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int begin = 1, end = nums.length - 1;
		int num = nums[0];
		while (begin < end) {
			System.out.println("end: "+end+"   begin; "+begin);
			if ((begin + end) / 2 == begin) {
				return Math.min(num, Math.min(nums[begin], nums[end]));
			}
			int tmp = nums[(begin + end) / 2];
			int location = (begin + end) / 2;
			if (tmp == num) {
				for (; location <= end; location++) {
					if (tmp != nums[location]) {
						tmp = nums[location];
						break;
					}

				}
			}
			if (tmp < num) {
				end = location;
				num = tmp;
			} else if (tmp > num) {
				begin = location;
			} else {
				end = (begin + end) / 2;
			}

		}
		return num;
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArrayII findMinimumInRotatedSortedArrayII = new FindMinimumInRotatedSortedArrayII();
		System.out.println(findMinimumInRotatedSortedArrayII.findMin(new int[] {3,1,3,3}));
	}
}
