package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationSystemTest {
	
	@Test
	public void givenHotelDetails_WhenProper_ShouldReturnTrue() {
		HotelReservationServiceIF hotel = new HotelReservationServiceImpl();
		boolean result = hotel.addHotel("Lakewood", 100.0, 110.0,80.0,80.0,3);
		Assert.assertTrue(result);
		
	}
	
	@Test
	public void givenDateRange_find_CheapestHotel() {
		HotelReservationServiceIF hotel = new HotelReservationServiceImpl();
		hotel.addHotel("Lakewood",110.0,90.0,80.0,80.0,3);
		hotel.addHotel("Bridgewood",150.0,50.0,110.0,50.0,4);
		hotel.addHotel("Ridgewood",220.0,150.0,100.0,40.0,5);
		List<Hotel> cheapestHotels = hotel.getCheapestHotel("10Sep2021", "11Sep2021",CustomerType.REGULAR);
		System.out.println("cheapest hotels: "+cheapestHotels);
		Assert.assertEquals("Lakewood", cheapestHotels.get(0).getHotelName());
		Assert.assertEquals("Bridgewood", cheapestHotels.get(1).getHotelName());
	}
	
	@Test
	public void givenDateRange_find_CheapestBestRatedHotel() {
		HotelReservationServiceIF hotel = new HotelReservationServiceImpl();
		hotel.addHotel("Lakewood",110.0,90.0,80.0,80.0,3);
		hotel.addHotel("Bridgewood",150.0,50.0,110.0,50.0,4);
		hotel.addHotel("Ridgewood",220.0,150.0,100.0,40.0,5);
		Hotel cheapestBestRatedHotel = hotel.getCheapestBestRatedHotel("10Sep2021", "11Sep2021",CustomerType.REGULAR);
		System.out.println("cheapest best rated: "+cheapestBestRatedHotel);
		Assert.assertEquals("Bridgewood", cheapestBestRatedHotel.getHotelName());
		
	}
	
	@Test
	public void givenDateRange_find_BestRatedHotel() {
		HotelReservationServiceIF hotel = new HotelReservationServiceImpl();
		hotel.addHotel("Lakewood",110.0,90.0,80.0,80.0,3);
		hotel.addHotel("Bridgewood",150.0,50.0,110.0,50.0,4);
		hotel.addHotel("Ridgewood",220.0,150.0,100.0,40.0,5);
		Hotel bestRatedHotel = hotel.getBestRatedHotel("10Sep2021", "11Sep2021",CustomerType.REGULAR);
		System.out.println("Best rated: "+bestRatedHotel);
		Assert.assertEquals("Ridgewood", bestRatedHotel.getHotelName());
	}
	
	@Test
	public void givenDateRangeAndRewardedUser_find_BestRatedHotel() {
		HotelReservationServiceIF hotel = new HotelReservationServiceImpl();
		hotel.addHotel("Lakewood",110.0,90.0,80.0,80.0,3);
		hotel.addHotel("Bridgewood",150.0,50.0,110.0,50.0,4);
		hotel.addHotel("Ridgewood",220.0,150.0,100.0,40.0,5);
		Hotel bestRatedHotel = hotel.getBestRatedHotel("10Sep2021", "11Sep2021",CustomerType.REWARD);
		System.out.println("the best rated hotel is : ");
		System.out.println(hotel);
		System.out.println();
		Assert.assertEquals("Ridgewood", bestRatedHotel.getHotelName());
	}
	
	@Test
	public void givenDateRangeAndRewardedCustomer_find_CheapestAndBestRatedHotel() {
		HotelReservationServiceIF hotel = new HotelReservationServiceImpl();
		hotel.addHotel("Lakewood",110.0,90.0,80.0,80.0,3);
		hotel.addHotel("Bridgewood",150.0,50.0,110.0,50.0,4);
		hotel.addHotel("Ridgewood",220.0,150.0,100.0,40.0,5);
		Hotel bestRatedHotel = hotel.getBestRatedHotel("10Sep2021", "11Sep2021",CustomerType.REWARD);
		System.out.println("the cheapest and best rated hotel is : ");
		System.out.println(bestRatedHotel);
		System.out.println();
		Assert.assertEquals("Ridgewood", bestRatedHotel.getHotelName());
	}
	
	@Test
	public void givenDateRangeAndRewardedCustomer_find_CheapestHotel() {
		
		HotelReservationServiceIF hotel = new HotelReservationServiceImpl();
		hotel.addHotel("Lakewood",110.0,90.0,80.0,80.0,3);
		hotel.addHotel("Bridgewood",150.0,50.0,110.0,50.0,4);
		hotel.addHotel("Ridgewood",220.0,150.0,100.0,40.0,5);
		Hotel bestRatedHotel = hotel.getBestRatedHotel("10Sep2021", "11Sep2021",CustomerType.REWARD);
		System.out.println("the cheapest hotel is : ");
		System.out.println(bestRatedHotel);
		System.out.println();
		Assert.assertEquals("Ridgewood", bestRatedHotel.getHotelName());
	}

}
