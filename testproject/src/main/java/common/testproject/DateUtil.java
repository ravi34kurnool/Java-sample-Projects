package common.testproject;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static void main(String[] args) {
		System.err.println(getDateByMonth(-1));
		System.err.println(getDateByMonth(1));
	}

	public static Date getDateByMonth(int month){
    	Calendar calNow = Calendar.getInstance();
		calNow.add(Calendar.MONTH, month);
		return calNow.getTime();
    }
}
