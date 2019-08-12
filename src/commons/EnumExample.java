package com.commons;

enum Week {
	MONDAY("monday"),
	TUESDAY("tuesday"),
	WEDNESDAY("wednesday"),
	THURSDAY("thursday"),
	FRIDAY("friday"),
	SATURDAY("saturday"),
	SUNDAY("sunday");
	
	private String code;
	
	Week(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}

public class EnumExample {
	
 public static void main(String[] args) {
	 Week w = Week.MONDAY;
	 
	 System.out.println(w.getCode());
 }
}
