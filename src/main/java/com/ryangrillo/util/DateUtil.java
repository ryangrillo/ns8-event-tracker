package com.ryangrillo.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class DateUtil {
	
	
	public static Date randomTodayOrYesterday() {
		Random r = new Random();
	    int i = r.nextInt((2 - 1) + 1) + 1;
	    if (i == 1){
	    	Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	    	cal.add(Calendar.DAY_OF_YEAR, -1);
	    	Date date = cal.getTime();
	    	return date;
	    } else {
	    	Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	    	cal.add(Calendar.DAY_OF_YEAR, -2);
	    	Date yesterday = cal.getTime();;
	    	return yesterday;
	    }
	}
	
	public static boolean getYesterday(Date date) {
		Calendar c1 = Calendar.getInstance(); 
		c1.add(Calendar.DAY_OF_YEAR, -2); 

		Calendar c2 = Calendar.getInstance();
		c2.setTime(date); 

		if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
		  && c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR)) {
			return true;
		}
		return false;
		        
		  
	}
}
