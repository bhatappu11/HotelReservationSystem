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
	public static int getNumOfDays(String date1, String date2) {
		LocalDate startDate = dateParser(date1);
		LocalDate endDate = dateParser(date2);
		Period period = Period.between(startDate, endDate);
		return period.getDays()+1;
	}
	public static int getNumOfWeekdays(String date1, String date2) {
		numOfWeekdays =0;
		numOfWeekends =0;
		LocalDate startDate = dateParser(date1);
		LocalDate endDate = dateParser(date2);
		Stream.iterate(startDate, date -> date.plusDays(1))
		  .limit(ChronoUnit.DAYS.between(startDate, endDate)+1)
		  .forEach(date -> {
			  if(date.getDayOfWeek().equals(DayOfWeek.SUNDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) numOfWeekends++;
			  else numOfWeekdays++;
		  });
		
		return numOfWeekdays;
	}
}
