package com.bridgelabz.hotelreservation;

import java.time.LocalDate;
import java.util.List;

public interface HotelReservationServiceIF {
	public void addHotel(String hotelName,Double regularWeekdayPrice,Double regularWeekendPrice,Double rewardWeekdayPrice,Double rewardWeekendPrice,int ratings);
	public List<Hotel> getCheapestHotel(String startDate,String endDate,CustomerType cType);
	public Hotel getCheapestBestRatedHotel(String startDate, String endDate,CustomerType cType);
	public Hotel getBestRatedHotel(String startDate, String endDate,CustomerType cType);
}
