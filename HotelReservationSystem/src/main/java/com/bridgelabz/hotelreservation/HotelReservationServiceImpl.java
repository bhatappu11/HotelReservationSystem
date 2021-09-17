package com.bridgelabz.hotelreservation;

import java.util.LinkedList;
import java.util.List;

public class HotelReservationServiceImpl implements HotelReservationServiceIF {
	
	List<Hotel> hotelList;
	
	
	public HotelReservationServiceImpl() {
		this.hotelList = new LinkedList<>();
	}

	@Override
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
}
