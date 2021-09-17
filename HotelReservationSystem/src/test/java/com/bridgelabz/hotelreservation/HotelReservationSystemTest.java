package com.bridgelabz.hotelreservation;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationSystemTest {
	
	@Test
	public void givenHotelDetails_WhenProper_ShouldReturnTrue() {
		HotelReservationServiceIF hotel = new HotelReservationServiceImpl();
		boolean result = hotel.addHotel("Lakewood", 100.0, 110.0);
		Assert.assertTrue(result);
		
	}
	
	@Test
	public void givenDateRange_find_CheapestHotel() {
		HotelReservationServiceIF hotel = new HotelReservationServiceImpl();
		hotel.addHotel("Lakewood",100.0,110.0);
		hotel.addHotel("Bridgewood",110.0,110.0);
		hotel.addHotel("Ridgewood",105.0,110.0);
		Hotel cheapestHotel = hotel.getCheapestHotel("10Sep2021", "11Sep2021");
		System.out.println(cheapestHotel.getHotelName());
	}
}
