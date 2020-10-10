package oj;


import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 1)
            return numerator + "";
        StringBuffer buffer = new StringBuffer();
        String res = "";
        res=(numerator / denominator)+"";

        numerator %= denominator;
        if (numerator == 0)
            return res.toString();
        res+=".";
        int i = 0;
        Map<Integer, Integer> tmp = new HashMap<>();
        while (numerator!=0){
            int beg=i;
            while (numerator <= denominator) {
                numerator *= 10;
                buffer.append("0");
                i++;
            }
            buffer.deleteCharAt(buffer.length()-1);
            if(numerator%denominator==0)
                return res+buffer.toString()+(numerator/denominator);
            int sub=numerator%denominator;
            if(!tmp.containsKey(sub)){
                tmp.put(sub,beg);
                buffer.append((numerator/denominator)+"");
                numerator=sub;
            }else {
                return res+buffer.substring(0,tmp.get(sub))+"("+buffer.substring(tmp.get(sub),beg)+")";
            }
        }
        return res;
    }

    public static void main(String[] args) {
       System.out.println( new FractionToRecurringDecimal().fractionToDecimal(4,333));
    }
}
