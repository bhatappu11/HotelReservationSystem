package com.bridgelabz.hotelreservation;

import java.util.LinkedList;
import java.util.List;

public class HotelReservationServiceImpl implements HotelReservationServiceIF {
	
	List<Hotel> hotelList;
	
	
	public HotelReservationServiceImpl() {
		this.hotelList = new LinkedList<>();
	}

	@Override
	public void addHotel(String hotelName, Double weekdayPrice, Double weekendPrice) {
			Hotel hotel = new Hotel(hotelName,weekdayPrice,weekendPrice);
			hotelList.add(hotel);
	}
}
