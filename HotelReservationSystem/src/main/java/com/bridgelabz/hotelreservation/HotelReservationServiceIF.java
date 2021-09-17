package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
import java.util.List;

public interface HotelReservationServiceIF {
	public boolean addHotel(String hotelName,Double weekdayPrice,Double weekendPrice,int ratings);
	public List<Hotel> getCheapestHotel(String startDate,String endDate);
	public Hotel getCheapestBestRatedHotel(String string, String string2);
}
