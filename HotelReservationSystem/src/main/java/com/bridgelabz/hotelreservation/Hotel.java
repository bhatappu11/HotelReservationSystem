package com.bridgelabz.hotelreservation;

import java.time.DayOfWeek;

public class Hotel {
	private String hotelName;
	private Double regularWeekdayPrice;
	private Double regularWeekendPrice;
	private Double rewardWeekdayPrice;
	private Double rewardWeekendPrice;
	private int ratings;
	
	
	public Hotel(String hotelName, Double regularWeekdayPrice, Double regularWeekendPrice, Double rewardWeekdayPrice,
			Double rewardWeekendPrice, int ratings) {
		super();
		this.hotelName = hotelName;
		this.regularWeekdayPrice = regularWeekdayPrice;
		this.regularWeekendPrice = regularWeekendPrice;
		this.rewardWeekdayPrice = rewardWeekdayPrice;
		this.rewardWeekendPrice = rewardWeekendPrice;
		this.ratings = ratings;
	}
	
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Double getRegularWeekdayPrice() {
		return regularWeekdayPrice;
	}

	public void setRegularWeekdayPrice(Double regularWeekdayPrice) {
		this.regularWeekdayPrice = regularWeekdayPrice;
	}

	public Double getRegularWeekendPrice() {
		return regularWeekendPrice;
	}

	public void setRegularWeekendPrice(Double regularWeekendPrice) {
		this.regularWeekendPrice = regularWeekendPrice;
	}

	public Double getRewardWeekdayPrice() {
		return rewardWeekdayPrice;
	}

	public void setRewardWeekdayPrice(Double rewardWeekdayPrice) {
		this.rewardWeekdayPrice = rewardWeekdayPrice;
	}

	public Double getRewardWeekendPrice() {
		return rewardWeekendPrice;
	}

	public void setRewardWeekendPrice(Double rewardWeekendPrice) {
		this.rewardWeekendPrice = rewardWeekendPrice;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public Double getTotalPrice(int numOfWeekdays, int numOfWeekends, CustomerType cType) {
		if(cType == CustomerType.REGULAR) return (regularWeekdayPrice*numOfWeekdays + regularWeekendPrice*numOfWeekends);
		return (rewardWeekdayPrice*numOfWeekdays + rewardWeekendPrice*numOfWeekends);
	}
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekdayPrice=" + regularWeekdayPrice + ", weekendPrice=" + regularWeekendPrice
				+ ", ratings=" + ratings + "]";
	}
	
	
	
}
