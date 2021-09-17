package com.bridgelabz.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelReservationServiceImpl implements HotelReservationServiceIF {
	
	List<Hotel> hotelList;
	int numOfWeekdays = 0, numOfWeekends = 0;
	
	
	public HotelReservationServiceImpl() {
		this.hotelList = new LinkedList<>();
	}

	public boolean addHotel(String hotelName, Double weekdayPrice, Double weekendPrice) {
			Hotel hotel = new Hotel(hotelName,weekdayPrice,weekendPrice);
			int oldSize = hotelList.size();
			hotelList.add(hotel);
			System.out.println(hotel);
			int newSize = hotelList.size();
			if(oldSize < newSize)
				return true;
			else 
				return false;
			
	}

	@Override
	public List<Hotel> getCheapestHotel(String startDate, String endDate) {
		long numOfDays = DateServiceProvider.getNumOfDays(startDate,endDate);
		LocalDate date1=DateServiceProvider.dateParser(startDate);
		LocalDate date2=DateServiceProvider.dateParser(endDate);
		Stream.iterate(date1, date -> date.plusDays(1))
		  .limit(ChronoUnit.DAYS.between(date1, date2)+1)
		  .forEach(date -> {
			  if(date.getDayOfWeek().equals(DayOfWeek.SUNDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) numOfWeekends++;
			  else numOfWeekdays++;
		  });

	Hotel cheapestHotel = hotelList.stream()
						.min((h1,h2) -> h1.getTotalPrice(numOfWeekdays,numOfWeekends).compareTo(h2.getTotalPrice(numOfWeekdays,numOfWeekends)))
						.orElse(null);
	double cheapestPrice = cheapestHotel.getTotalPrice(numOfWeekdays,numOfWeekends);
	System.out.println("the minimum price is : "+cheapestPrice);
	Predicate<Hotel> isMinimum = (hotel) -> (hotel.getTotalPrice(numOfWeekdays,numOfWeekends) == cheapestPrice)?true:false; 
	List<Hotel> cheapestHotels = hotelList.stream()
								 .filter(isMinimum)
								 .collect(Collectors.toList());
	return cheapestHotels;
	}

	@Override
	public String toString() {
		return "HotelReservationServiceImpl [hotelList=" + hotelList + "]";
	}
	
	
}
