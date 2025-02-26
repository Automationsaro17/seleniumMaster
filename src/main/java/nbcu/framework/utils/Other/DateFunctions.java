package nbcu.framework.utils.Other;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateFunctions {

	/**
	 * To convert date string to date
	 * 
	 * @param dateString            - date string
	 * @param inputDateStringFormat - date format of date string
	 * @return - date
	 * @throws Exception
	 */
	public static Date convertDateStringToDate(String dateString, String inputDateStringFormat) throws Exception {
		Date convertedDate = null;
		try {
			convertedDate = new SimpleDateFormat(inputDateStringFormat).parse(dateString);
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		return convertedDate;
	}

	/**
	 * To generate add/subtract no of days from current date
	 * 
	 * @param dateFormat - date format
	 * @param days       - no of days to add or subtract
	 * @return
	 * @throws Exception
	 */
	public static String addOrMinusDateFromCurrentDate(String dateFormat, String days) throws Exception {
		String updatedDate = "";
		try {
			SimpleDateFormat fsimpleDateFormat = new SimpleDateFormat(dateFormat);
			Date currentDate = new Date();
			Calendar calender = Calendar.getInstance();
			calender.setTime(currentDate);
			calender.add(Calendar.DATE, Integer.parseInt(days));
			updatedDate = fsimpleDateFormat.format(calender.getTime());

		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		return updatedDate;

	}

	/**
	 * To generate add/subtract no of hours from current time
	 * 
	 * @param timeFormat - time format
	 * @param hours      - no of hours to add or subtract
	 * @return
	 * @throws Exception
	 */
	public static String addOrMinusTimeFromCurrentTime(String timeFormat, String hours) throws Exception {
		String updatedTime = "";
		try {
			SimpleDateFormat fsimpleDateFormat = new SimpleDateFormat(timeFormat);
			Date currentDate = new Date();
			Calendar calender = Calendar.getInstance();
			calender.setTime(currentDate);
			calender.add(Calendar.HOUR, Integer.parseInt(hours));
			updatedTime = fsimpleDateFormat.format(calender.getTime());

		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
		return updatedTime;

	}
	/**
	 * To get time in EDT
	 * 
	 * @param time - time string e.g. 4:30 PM
	 * @return time string in EDT :   7:00 AM
	 */
	public static String getTimeInEDT(String time) {
		LocalTime convertedTime = LocalTime.parse(time.toLowerCase(),DateTimeFormatter.ofPattern("h:m a"))
										   .minusHours(9).minusMinutes(30);
		return convertedTime.format(DateTimeFormatter.ofPattern("h:mm a")).toUpperCase();
	}
	/**
	 * To get date in format using DateTimeFormatter
	 * 
	 * @param format -  e.g. "MM/dd/yyyy"
	 * @param offset - number of days before or ahead from today
	 * @return date string in the format given
	 */
	public static String getDateUsingOffsetFromToday(String format,int offset) {
		format = format == null ? "MM/dd/yyyy" : format;
		return LocalDate.now().plusDays(offset).format(DateTimeFormatter.ofPattern(format));
	}
}
