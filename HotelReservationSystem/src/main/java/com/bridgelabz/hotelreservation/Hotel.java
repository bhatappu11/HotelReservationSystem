package com.bridgelabz.hotelreservation;

public class Hotel {
	private String hotelName;
	private Double weekdayPrice;
	private Double weekendPrice;
	
	public Hotel(String hotelName, Double weekdayPrice, Double weekendPrice) {
		this.hotelName = hotelName;
		this.weekdayPrice = weekdayPrice;
		this.weekendPrice = weekendPrice;
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
	@Override
	public String toString() {
		return "Hotel [HotelName=" + hotelName + ", WeekdayPrice=" + weekdayPrice + ", WeekendPrice=" + weekendPrice
				+ "]";
	}
	
	
	
}
