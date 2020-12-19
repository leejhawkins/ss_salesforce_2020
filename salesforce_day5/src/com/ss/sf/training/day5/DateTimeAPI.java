package com.ss.sf.training.day5;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateTimeAPI {
	
	// Assignment five, all answers print to the console	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime myBD = LocalDateTime.of(1987,Month.JUNE, 26, 1, 00,00,000001);
		
		System.out.println("Question 1: My Birthday in date time:\n" + myBD);
		
		System.out.println("\nQuestion 2: The Thursday before my birthday was:\n" + myBD.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));
		
		System.out.println("\nQuestion 3:\n Zone Id is the zone you are in ZoneOffset is the number of hours offset from Greenwich/UTC time\n");
		
		ZonedDateTime zt = Instant.now().atZone(ZoneId.systemDefault());
		Instant instance = ZonedDateTime.now().toInstant();
		
		System.out.println("Question 4:\n instant to Zone time:"  + zt + "\n Zone time to instant:" + instance);
		
		int year = 1998;
		
		System.out.println("\nQuestion 5:\nDays in each month of 1998:");
		
		for (Month month : Month.values()) {
			YearMonth ym = YearMonth.of(year, month);
			System.out.println("There were " + ym.lengthOfMonth() + " in " + month + " of "+ year);
		}
		Month month = Month.valueOf("JANUARY");
		LocalDate date = Year.now().atMonth(month).atDay(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		Month january = month;
		System.out.println("\nQuestion 6:\nMondays in January of this year:");
		while (month == january) {
			System.out.println("Monday in January: " + date);
			date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
			january = date.getMonth();
		}
		
		System.out.println("\nQuestion 7:\nDid a certain date fall on a Friday?");
		List<LocalDate> fr13 = new ArrayList<>();
		
		for (int i =1; i < 13; i++) {
			fr13.add(LocalDate.of(2013,i,13));
		}
		;
		
		fr13.forEach(day -> {
			if (day.getDayOfWeek() == DayOfWeek.FRIDAY) {
				System.out.println(day + " fell on a Friday...Spooky");
			} else {
				System.out.println(day + " was not on a Friday.... boring");
			}
		});
		
		
		
	}

}
