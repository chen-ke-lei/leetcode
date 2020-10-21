package oj.cap210;

public class Q5537 {
    public boolean checkPalindromeFormation(String a, String b) {
        if(a.length()<=1)
            return true;
        int left=0,right=a.length()-1;

        while (left<right){
            if(a.charAt(left)==b.charAt(right)){
                left++;
                right--;
            }else {
                break;
            }
        }
        if(judge(a.substring(left,right+1)))return true;
        if(judge(b.substring(left,right+1))) return true;
        left=0;
        right=a.length()-1;
        while (left<right){
            if(b.charAt(left)==a.charAt(right)){
                left++;
                right--;
            }else {
                break;
            }
        }
        if(judge(a.substring(left,right+1)))return true;
        if(judge(b.substring(left,right+1))) return true;
        return false;
    }
        boolean judge(String a){
            int left=0,right=a.length()-1;
            while (left<right){
                if(a.charAt(left)==a.charAt(right)){
                    left++;
                    right--;
                }else {
                    return false;
                }
            }
            return true;
        }
    public static void main(String[] args) {
        System.out.println(new Q5537().checkPalindromeFormation("ulacfd"
                ,"jizalu"));
    }
}
