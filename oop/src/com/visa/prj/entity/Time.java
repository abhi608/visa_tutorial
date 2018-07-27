package com.visa.prj.entity;

public class Time {
	private int hours;
	private int minutes;
	public Time(int hours, int minutes) {
		super();
		this.hours = hours;
		this.minutes = minutes;
	}

	public static Time add(Time t1, Time t2) {
		int epoch = t1.getHours()*60 + t1.getMinutes() + t2.getHours()*60 + t2.getMinutes();
		int hours = epoch/60;
		int minutes = epoch%60;
		Time t3 = new Time(hours, minutes);
		return t3;
	}
	
	public int getHours() {
		return this.hours;
	}
	
	public int getMinutes() {
		return this.minutes;
	}
	
	public Time add(Time t1) {
		int epoch = this.getHours()*60 + this.getMinutes() + t1.getHours()*60 + t1.getMinutes();
		int hours = epoch/60;
		int minutes = epoch%60;
		Time t3 = new Time(hours, minutes);
		return t3;
	}
	
}
