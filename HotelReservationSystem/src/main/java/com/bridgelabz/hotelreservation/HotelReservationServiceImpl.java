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

	public void addHotel(String hotelName, Double regularWeekdayPrice, Double regularWeekendPrice,Double rewardWeekdayPrice,Double rewardWeekendPrice,int ratings) {
		try {
			if(hotelName.length() == 0) throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_EMPTY, "Empty string is passed invalid");
			Hotel hotel = new Hotel(hotelName,regularWeekdayPrice,regularWeekendPrice,rewardWeekdayPrice, rewardWeekendPrice, ratings);
			hotelList.add(hotel);
		}
		catch(NullPointerException e) {
			throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_NULL, "Null string is passed invalid");
		}
	}

	@Override
	public List<Hotel> getCheapestHotel(String startDate, String endDate,CustomerType cType) {
		try {
			if(startDate.length() == 0 || endDate.length() == 0)
				throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_EMPTY, "Empty string is passed invalid");
			int numOfDays = DateServiceProvider.getNumOfDays(startDate,endDate);
			numOfWeekdays = DateServiceProvider.getNumOfWeekdays(startDate,endDate);
			numOfWeekends = numOfDays - numOfWeekdays;
			Hotel cheapestHotel = hotelList.stream()
								.min((h1,h2) -> h1.getTotalPrice(numOfWeekdays,numOfWeekends,cType).compareTo(h2.getTotalPrice(numOfWeekdays,numOfWeekends,cType)))
								.orElse(null);
			double cheapestPrice = cheapestHotel.getTotalPrice(numOfWeekdays,numOfWeekends,cType);
			System.out.println("Minimum Price is : "+cheapestPrice);
			Predicate<Hotel> isMinimum = (hotel) -> (hotel.getTotalPrice(numOfWeekdays,numOfWeekends,cType) == cheapestPrice)?true:false; 
			List<Hotel> cheapestHotels = hotelList.stream()
										 .filter(isMinimum)
										 .collect(Collectors.toList());
			return cheapestHotels;
			}
		catch(NullPointerException e) {
			throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_NULL, "Null string is passed invalid");
		}
	}

	@Override
	public String toString() {
		return "HotelReservationServiceImpl [hotelList=" + hotelList + "]";
	}

	@Override
	public Hotel getCheapestBestRatedHotel(String startDate, String endDate,CustomerType cType) {
		try {
			if(startDate.length() == 0 || endDate.length() == 0)
				throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_EMPTY, "Empty string is passed invalid");
			List<Hotel> cheapestHotels = getCheapestHotel(startDate,endDate,cType);
			return cheapestHotels.stream()
				   .max((h1,h2) -> h1.getRatings()-h2.getRatings())
				   .orElse(null);
		}
		catch(NullPointerException e) {
			throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_NULL, "Null string is passed invalid");
		}
		
	}

	@Override
	public Hotel getBestRatedHotel(String startDate, String endDate,CustomerType cType) {
		try {
			if(startDate.length() == 0 || endDate.length() == 0)
				throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_EMPTY, "Empty string is passed invalid");
		
			Hotel bestRated = hotelList.stream()
				   .max((h1,h2) -> h1.getRatings()-h2.getRatings())
				   .orElse(null);
			int numOfDays = DateServiceProvider.getNumOfDays(startDate,endDate);
			numOfWeekdays = DateServiceProvider.getNumOfWeekdays(startDate,endDate);
			numOfWeekends = numOfDays - numOfWeekdays;
			System.out.print("Total price: "+bestRated.getTotalPrice(numOfWeekdays, numOfWeekends,cType));
			return bestRated;
		}
		catch(NullPointerException e) {
			throw new HotelManagementException(HotelManagementException.exceptionType.ENTERED_NULL, "Null string is passed invalid");
	}
	}
	
	
}
