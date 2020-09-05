package oj.swordtooffer;

public class Problem46 {
    public int translateNum(int num) {
        String str = num + "";
        int pre = 1, res = 1, preNum = str.charAt(0) - '0';
        for (int i = 1; i < str.length(); i++) {
            int tmp = str.charAt(i) - '0';
            if (preNum == 0) {
                if (tmp == 0) return 0;
                pre = res;
            } else {
                if (preNum * 10 + tmp <= 25) {
                    int a = res;
                    res += pre;
                    pre = a;
                } else {
                    pre = res;
                }
            }
            preNum = tmp;
        }
        return res;
    }
}
