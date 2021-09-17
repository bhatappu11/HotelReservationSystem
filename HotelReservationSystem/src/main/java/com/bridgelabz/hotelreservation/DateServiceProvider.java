package com.bridgelabz.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;


public class DateServiceProvider {
	private static int numOfWeekends=0;
	private static int numOfWeekdays=0;
	public static LocalDate dateParser(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
		LocalDate parsedDate = LocalDate.parse(date,formatter);
		return parsedDate;
	}
	public static long getNumOfDays(String date1, String date2) {
		LocalDate startDate = dateParser(date1);
		LocalDate endDate = dateParser(date2);
		Period period = Period.between(startDate, endDate);
		return period.getDays()+1;
	}
	
}
