
/*
 * 
 * 2. Write the definition for a class called time that has hours and minutes as integer. The class has the following member functions:
void settime(int, int) to set the specified value in object
void showtime() to display time object
time sum(time) to sum two time object & return time
1. Write the definitions for each of the above member functions.
2. Write main function to create three time objects. Set the value in two objects and call sum() to calculate sum and assign it in third object. Display all time objects. 
 * 
 * */
 

package com.montran.pojo;

public class Time {
	private int hours;
	private int minutes;
	
	public void settime(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public void showTime() {
		System.out.println(hours + ":" + minutes);
	}
	
	public Time Sum(Time time2) {
		Time time3 = new Time();
		time3.hours = this.hours + time2.hours;
		time3.minutes = this.minutes + time2.minutes;
		return time3;
		
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return  hours + ":" + minutes;
		}
}
