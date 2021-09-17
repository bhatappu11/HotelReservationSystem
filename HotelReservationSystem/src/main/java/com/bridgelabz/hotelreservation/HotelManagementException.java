package com.bridgelabz.hotelreservation;

public class HotelManagementException extends RuntimeException{
	enum exceptionType{
		ENTERED_NULL,ENTERED_EMPTY
	}
	exceptionType etype;
	public HotelManagementException(exceptionType type, String message) {
		super(message);
		this.etype = type;
	}
}
