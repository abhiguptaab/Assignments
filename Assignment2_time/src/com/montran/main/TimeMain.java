package com.montran.main;
import java.util.*;

import com.montran.pojo.Time;

public class TimeMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Time time1 = new Time();
		Time time2 = new Time();
		
		System.out.println("Enter hours and Minutes");
		int hours = sc.nextInt();
		int minutes = sc.nextInt();
		
		time1.settime(hours, minutes);
			
		System.out.println("Enter hours and Minutes");
		hours = sc.nextInt();
		minutes = sc.nextInt();
		
		time2.settime(hours, minutes);
		
		System.out.println("Sum of two time = " + time1.Sum(time2) );
	}

}
