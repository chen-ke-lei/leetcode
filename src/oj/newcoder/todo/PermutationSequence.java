package oj.newcoder.todo;
// TODO: 2020/1/31
public class PermutationSequence {
    public static void main(String[] av) {
        System.out.println(new PermutationSequence().getPermutation(3, 2));
    }

    public String getPermutation(int n, int k) {
        if (k == 0)
            return "";
        String res = "";
        boolean[] tmp = new boolean[n];
        int mutl = 1;
        for (int i = 1; i <n; i++)
            mutl *= i;
        for (int i = 0; i < n-1; i++) {
            System.out.println(k);
            System.out.println(mutl);


            int pointer = 0;
            if (k  >=(mutl+1)) {

                pointer = k / (mutl+1);
                k -= mutl;
            }
            System.out.println(pointer);
            System.out.println(  );
            int j = 0;

            while (pointer >= 0) {
                if (pointer == 0 && tmp[j] == false) {
                    tmp[j] = true;
                    res += (j + 1);
                    pointer--;
                } else if (tmp[j]) {
                    j++;
                } else {
                    pointer--;
                    j++;
                }
            }
            if (i < n - 1)
                mutl /= (n - i - 1);
        }
        for(int i=0;i<n;i++)
            if(!tmp[i]){
                res+=(i+1);
                break;
            }
        return res;
    }
}
