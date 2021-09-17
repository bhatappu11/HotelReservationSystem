package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;

public class HotelReservationServiceImpl implements HotelReservationServiceIF {
	
	List<Hotel> hotelList;
	
	
	public HotelReservationServiceImpl() {
		this.hotelList = new LinkedList<>();
	}

	public boolean addHotel(String hotelName, Double weekdayPrice, Double weekendPrice) {
			Hotel hotel = new Hotel(hotelName,weekdayPrice,weekendPrice);
			int oldSize = hotelList.size();
			hotelList.add(hotel);
			int newSize = hotelList.size();
			if(oldSize < newSize)
				return true;
			else 
				return false;
			
	}

	@Override
	public Hotel getCheapestHotel(LocalDate startDate, LocalDate endDate) {
		Period period = Period.between(startDate, endDate);
		int numOfDays = period.getDays();
		Hotel hotel = hotelList.stream().min((h1,h2) -> {
			return (int) (h1.getWeekdayPrice() - h2.getWeekdayPrice());
		}).orElse(null);
		
		return hotel;
	}
}
