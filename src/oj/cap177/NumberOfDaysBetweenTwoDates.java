package oj.cap177;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NumberOfDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        long res=0;
        try {
            Date d1=dateFormat.parse(date1);
            Date d2=dateFormat.parse(date2);
           res= (d2.getTime()-d1.getTime())/(24*3600*1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return (int)res;
    }
}
