package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
import java.util.List;

public interface HotelReservationServiceIF {
	public boolean addHotel(String hotelName,Double weekdayPrice,Double weekendPrice);
	public List<Hotel> getCheapestHotel(String startDate,String endDate);
}
