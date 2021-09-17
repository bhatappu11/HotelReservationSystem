package com.bridgelabz.hotelreservation;

import java.time.DayOfWeek;

public class Hotel {
	private String hotelName;
	private Double weekdayPrice;
	private Double weekendPrice;
	private int ratings;
	
	public Hotel(String hotelName, Double weekdayPrice, Double weekendPrice,int ratings) {
		this.hotelName = hotelName;
		this.weekdayPrice = weekdayPrice;
		this.weekendPrice = weekendPrice;
		this.ratings = ratings;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Double getWeekdayPrice() {
		return weekdayPrice;
	}
	public void setWeekdayPrice(Double weekdayPrice) {
		this.weekdayPrice = weekdayPrice;
	}
	public Double getWeekendPrice() {
		return weekendPrice;
	}
	public void setWeekendPrice(Double weekendPrice) {
		this.weekendPrice = weekendPrice;
	}	
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public Double getTotalPrice(int numOfWeekdays, int numOfWeekends) {
		return this.weekdayPrice*numOfWeekdays + this.weekendPrice*numOfWeekends;
	}
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekdayPrice=" + weekdayPrice + ", weekendPrice=" + weekendPrice
				+ ", ratings=" + ratings + "]";
	}
	
	
	
}
