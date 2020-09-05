package oj.cap177;

import java.util.HashSet;
import java.util.Set;

public class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> nums=new HashSet<>();
        int num=0;
        for(int i=0;i<leftChild.length;i++){
            if(leftChild[i]!=-1){
                if(nums.contains(leftChild[i]))
                    return false;
                nums.add(leftChild[i]);
                num++;
            }
        }
        for(int i=0;i<rightChild.length;i++){
            if(rightChild[i]!=-1){
                if(nums.contains(rightChild[i]))
                    return false;
                nums.add(rightChild[i]);
                num++;
            }
        }
        if(num!=n-1)
            return false;
        return true;
    }
}
