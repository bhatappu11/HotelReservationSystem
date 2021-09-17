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

	public boolean addHotel(String hotelName, Double regularWeekdayPrice, Double regularWeekendPrice,Double rewardWeekdayPrice,Double rewardWeekendPrice,int ratings) {
			Hotel hotel = new Hotel(hotelName,regularWeekdayPrice,regularWeekendPrice,rewardWeekdayPrice, rewardWeekendPrice, ratings);
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
	public List<Hotel> getCheapestHotel(String startDate, String endDate,CustomerType cType) {
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

	@Override
	public String toString() {
		return "HotelReservationServiceImpl [hotelList=" + hotelList + "]";
	}

	@Override
	public Hotel getCheapestBestRatedHotel(String startDate, String endDate,CustomerType cType) {
		List<Hotel> cheapestHotels = getCheapestHotel(startDate,endDate,cType);
		return cheapestHotels.stream()
				   .max((h1,h2) -> h1.getRatings()-h2.getRatings())
				   .orElse(null);
		
	}

	@Override
	public Hotel getBestRatedHotel(String startDate, String endDate,CustomerType cType) {
		Hotel bestRated = hotelList.stream()
				   .max((h1,h2) -> h1.getRatings()-h2.getRatings())
				   .orElse(null);
		int numOfDays = DateServiceProvider.getNumOfDays(startDate,endDate);
		numOfWeekdays = DateServiceProvider.getNumOfWeekdays(startDate,endDate);
		numOfWeekends = numOfDays - numOfWeekdays;
		System.out.print("Total price: "+bestRated.getTotalPrice(numOfWeekdays, numOfWeekends,cType));
		return bestRated;
	}
	
	
}
