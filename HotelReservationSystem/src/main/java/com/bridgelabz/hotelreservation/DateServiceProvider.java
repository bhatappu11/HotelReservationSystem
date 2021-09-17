package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateServiceProvider {

	public static long getNumOfDays(String Date1, String Date2) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMuuuu");
		LocalDate startDate = LocalDate.parse(Date1,formatter);
		LocalDate endDate =LocalDate.parse(Date2,formatter);
		Period period = Period.between(startDate, endDate);
		return period.getDays()+1;
	}

}
