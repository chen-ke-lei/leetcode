package oj;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsOfSubarrays {
	public static void main(String[] args) {
		System.out.println(new BitwiseORsOfSubarrays().subarrayBitwiseORs(new int[]{0}));
	}
	//too slow
	public int subarrayBitwiseORs(int[] A) {
		Set<Integer> res =new HashSet<>(),tmp=new HashSet<>(),pre=new HashSet<>();
		Integer[] tmparray=new Integer[A.length+1];
		for(int i=0;i<A.length;i++) {
			tmparray[i]=A[i];
		}
		tmparray[A.length]=0;
		while (tmparray.length>1) {
			for(int i=0;i<tmparray.length;i++) {
				if(tmp.contains(tmparray[i]))
					pre.add(tmparray[i]);
				tmp.add(tmparray[i]);
			}
			tmparray=(Integer[]) tmp.toArray(new Integer[pre.size()]);
			for(int i=0;i<tmparray.length-1;i++) {
				for( int j=i+1;j<tmparray.length;j++)
					pre.add(tmparray[i]|tmparray[j]);
			}
			tmparray=(Integer[]) pre.toArray(new Integer[pre.size()]);
			res.addAll(pre);
			tmp=pre;
			pre=new HashSet<>();
		}
		
		return res.size();
	}
}
