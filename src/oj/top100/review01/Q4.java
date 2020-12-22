package oj.top100.review01;

public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 1)
            return findKthNum(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
        return (findKthNum(nums1, nums2, (nums1.length + nums2.length) / 2) +
                findKthNum(nums1, nums2, (nums1.length + nums2.length) / 2 + 1)) / 2.0;

    }

    int findKthNum(int[] nums1, int[] nums2, int k) {
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == nums1.length) return nums2[index2 + k - 1];
            if (index2 == nums2.length) return nums1[index1 + k - 1];
            if (k == 1) return Math.min(nums1[index1], nums2[index2]);
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half - 1, nums1.length - 1);
            int nexIndex2 = Math.min(index2 + half - 1, nums2.length - 1);
            if (nums1[newIndex1] < nums2[nexIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (nexIndex2 - index2 + 1);
                index2 = nexIndex2 + 1;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Q4().findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }
}
