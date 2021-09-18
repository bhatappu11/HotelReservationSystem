package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HotelReservationSystemTest {
	HotelReservationServiceIF hotel; 
	@Before
	public void initialize() {
		hotel = new HotelReservationServiceImpl();
		hotel.addHotel("Lakewood",110.0,90.0,80.0,80.0,3);
		hotel.addHotel("Bridgewood",150.0,50.0,110.0,50.0,4);
		hotel.addHotel("Ridgewood",220.0,150.0,100.0,40.0,5);
	}
	@Test
	public void givenHotelData_whenAdded_ShouldGetTrue() {
		HotelReservationServiceImpl hotel = new HotelReservationServiceImpl();
		int oldSize = hotel.hotelList.size();
		hotel.addHotel("Taj", 110.0, 90.0, 80.0, 70.0, 3);
		Assert.assertSame(oldSize+1,hotel.hotelList.size());
	}
	
	@Test
	public void givenHotelDetails_WhenProper_ShouldReturnTrue() {
		HotelReservationServiceImpl hotel = new HotelReservationServiceImpl();
		int oldSize = hotel.hotelList.size();
		hotel.addHotel("Lakewood", 100.0, 110.0,80.0,80.0,3);
		Assert.assertSame(oldSize+1,hotel.hotelList.size());
		
	}
	
	@Test
	public void givenDateRange_find_CheapestHotel() {
		List<Hotel> cheapestHotels = hotel.getCheapestHotel("10Sep2021", "11Sep2021",CustomerType.REGULAR);
		System.out.println("cheapest hotels: "+cheapestHotels);
		Assert.assertEquals("Lakewood", cheapestHotels.get(0).getHotelName());
		Assert.assertEquals("Bridgewood", cheapestHotels.get(1).getHotelName());
	}
	
	@Test
	public void givenDateRange_find_CheapestBestRatedHotel() {
		Hotel cheapestBestRatedHotel = hotel.getCheapestBestRatedHotel("10Sep2021", "11Sep2021",CustomerType.REGULAR);
		System.out.println(" cheapest best rated: "+cheapestBestRatedHotel);
		Assert.assertEquals(" Bridgewood", cheapestBestRatedHotel.getHotelName());
		
	}
	
	@Test
	public void givenDateRange_find_BestRatedHotel() {
		Hotel bestRatedHotel = hotel.getBestRatedHotel("10Sep2021", "11Sep2021",CustomerType.REGULAR);
		System.out.println(" Best rated: "+bestRatedHotel);
		Assert.assertEquals(" Ridgewood", bestRatedHotel.getHotelName());
	}
	
	@Test
	public void givenDateRangeAndRewardedUser_find_BestRatedHotel() {
		Hotel bestRatedHotel = hotel.getBestRatedHotel("10Sep2021", "11Sep2021",CustomerType.REWARD);
		System.out.println(" best rated hotel is : ");
		System.out.println(hotel);
		System.out.println();
		Assert.assertEquals("Ridgewood", bestRatedHotel.getHotelName());
	}
	
	@Test
	public void givenDateRangeAndRewardedCustomer_find_CheapestAndBestRatedHotel() {
		Hotel bestRatedHotel = hotel.getBestRatedHotel("10Sep2021", "11Sep2021",CustomerType.REWARD);
		System.out.println("cheapest best rated hotel is : ");
		System.out.println(bestRatedHotel);
		System.out.println();
		Assert.assertEquals("Ridgewood", bestRatedHotel.getHotelName());
	}
	
	@Test
	public void givenDateRangeAndRewardedCustomer_find_CheapestHotel() {
		
		Hotel bestRatedHotel = hotel.getBestRatedHotel("10Sep2021", "11Sep2021",CustomerType.REWARD);
		System.out.println(" cheapest hotel is : ");
		System.out.println(bestRatedHotel);
		System.out.println();
		Assert.assertEquals(" Ridgewood", bestRatedHotel.getHotelName());
	}
	
	@Test
	public void givenDateRange_IfNull_ShouldThrowException() {
		ExpectedException exceptionRule = ExpectedException.none();
		exceptionRule.expect(HotelManagementException.class);
		try {
			Hotel resultHotel = hotel.getBestRatedHotel(null,"12Sep2020",CustomerType.REWARD);
		}
		catch(HotelManagementException e) {
			Assert.assertEquals(HotelManagementException.exceptionType.ENTERED_NULL, e.etype);
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void givenDateRange_IfEmpty_ShouldThrowException() {
		HotelReservationServiceIF hotel = new HotelReservationServiceImpl();
		hotel.addHotel("Lakewood",110.0,90.0,80.0,80.0,3);
		hotel.addHotel("Bridgewood",150.0,50.0,110.0,50.0,4);
		hotel.addHotel("Ridgewood",220.0,150.0,100.0,40.0,5);
		ExpectedException exceptionRule = ExpectedException.none();
		exceptionRule.expect(HotelManagementException.class);
		try {
			Hotel resultHotel = hotel.getBestRatedHotel("","12Sep2020",CustomerType.REWARD);
		}
		catch(HotelManagementException e) {
			Assert.assertEquals(HotelManagementException.exceptionType.ENTERED_EMPTY, e.etype);
			System.out.println(e.getMessage());
		}
	}

}
