package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
import java.util.List;

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
		hotel.addHotel("Lakewood",110.0,90.0);
		hotel.addHotel("Bridgewood",150.0,50.0);
		hotel.addHotel("Ridgewood",220.0,150.0);
		List<Hotel> cheapestHotels = hotel.getCheapestHotel("10Sep2021", "11Sep2021");
		System.out.println(cheapestHotels);
	}
}
