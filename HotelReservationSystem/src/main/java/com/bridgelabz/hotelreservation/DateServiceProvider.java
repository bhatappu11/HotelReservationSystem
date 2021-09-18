package com.bridgelabz.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class DateServiceProvider {
	private static int numOfWeekends=0;
	private static int numOfWeekdays=0;
	
	private static final String DATE_REGEX = "^[0-3][0-9][A-Z][a-z]{2}(202)[0-9]$";
	
	@FunctionalInterface
	interface Validation{
		boolean inputCheck(String regex, String input);
	}
	static Validation dateValidator = (String regex, String input) -> { 
		boolean check= Pattern.matches(regex,input);
		return check;
	};
	
	public boolean getDateFormate(String date1, String date2) {
		if((dateValidator.inputCheck(DATE_REGEX,date1) && dateValidator.inputCheck(DATE_REGEX,date2))) return true;
		System.out.println("enter correct date");
		return false;
	}
	
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
