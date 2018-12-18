package common.testproject;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static void main(String[] args) {
		System.err.println(getDateByMonth(-1));
		System.err.println(getDateByMonth(1));
		
		System.out.println("==================================");
		Calendar calNow = Calendar.getInstance();
		calNow.set(Calendar.MONTH, 6);
		System.out.println("Current Date  :"+calNow.getTime());
		Date date = setDays(120,calNow.getTime());
		System.out.println("date : "+ date);
		System.out.println("is it after specified date - LICENSE EXPIARED  :"+date.before(new Date()));
	}

	public static Date getDateByMonth(int month){
    	Calendar calNow = Calendar.getInstance();
		calNow.add(Calendar.MONTH, month);
		return calNow.getTime();
    }
	
	public static Date setDays(int days, Date createdDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(createdDate);
		cal.add(Calendar.DAY_OF_YEAR, days);
		return cal.getTime();
	}
}
