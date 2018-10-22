package oj;

import java.util.HashSet;
import java.util.Set;

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		String res = "";
		if (numerator > denominator) {
			res += numerator / denominator;
			numerator = numerator % denominator;
		} else {
			res = "0";
		}
		if (numerator != 0)
			res += '.';
		int bit=0;
		int tmp=denominator;
		while (tmp>0) {
			tmp/=10;
			bit++;
		}
		Set<String> nums=new HashSet<>();
		return res;
	}
}
