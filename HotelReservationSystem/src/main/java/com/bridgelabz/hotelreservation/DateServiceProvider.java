package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class DateServiceProvider {
	public static LocalDate dateParser(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
		LocalDate parsedDate = LocalDate.parse(date,formatter);
		return parsedDate;
	}
	public static long getNumOfDays(String Date1, String Date2) {
		LocalDate startDate = dateParser(Date1);
		LocalDate endDate = dateParser(Date2);
		Period period = Period.between(startDate, endDate);
		return period.getDays()+1;
	}

}
