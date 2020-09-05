package oj.swordtooffer;

public class Problem40 {
    public static void main(String[] av) {
        Problem40 problem40 = new Problem40();
        problem40.getLeastNumbers(new int[]{0, 1, 2, 1}, 1);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0)
            return new int[0];
        int[] res = new int[k];
        int beg = getStart(arr, k, 0, arr.length - 1);
        for (int i = 0; i < res.length; i++)
            res[i] = arr[beg + i];
        return res;
    }

    int getStart(int[] arr, int k, int bg, int ed) {
        // System.out.println(Arrays.toString(arr) + bg);
        int left = bg, right = ed;
        int tmp = arr[bg];
        while (left < right) {
            while (arr[right] >= tmp && right > left) {
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] <= tmp && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;

        if (left - bg + 1 < k) {
            return getStart(arr, k - left + bg - 1, right, ed);
        } else if (left - bg + 1 > k)
            return getStart(arr, k, bg, left);
        else
            return bg;
    }
}
