package oj.newcoder;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            if ((leftC < 97 || leftC > 122) && (leftC < '0' || leftC > '9') && (leftC < 'A' || leftC > 'Z')) left++;
            else if ((rightC < 97 || rightC > 122) && (rightC < '0' || rightC > '9') && (rightC < 'A' || rightC > 'Z'))
                right--;
            else if(rightC==leftC||rightC-leftC==32||leftC-rightC==32){
                right--;
                left++;
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] av) {
        System.out.println('z' - 'Z');
    }
}
