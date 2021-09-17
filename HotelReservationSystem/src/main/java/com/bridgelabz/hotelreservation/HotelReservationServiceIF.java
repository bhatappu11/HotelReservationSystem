package com.bridgelabz.hotelreservation;

import java.time.LocalDate;

public interface HotelReservationServiceIF {
	public boolean addHotel(String hotelName,Double weekdayPrice,Double weekendPrice);
	public Hotel getCheapestHotel(String startDate,String endDate);
}
