package com.bridgelabz.hotelreservation;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationSystemTest {
	
	@Test
	public void givenHotelDetails_WhenProper_ShouldReturnTrue() {
		HotelReservationServiceIF hotel = new HotelReservationServiceImpl();
		boolean result = hotel.addHotel("Lakewood", 100.0, 110.0);
		Assert.assertTrue(result);
		
	}
}
