package com.immutable.alias;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.joda.time.DateTime;
import org.junit.Test;

public class CalendarTest {

	
	@Test
	public void testCreateTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);

		SimpleDateFormat sdf =
			  new SimpleDateFormat("E MM/dd/yyyy HH:mm:ss.SSS");

		System.out.println("calendar time======" + sdf.format(calendar.getTime()));
	}
	
	
	@Test
	public void testJotaTime() {
		DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);

		System.out.println("joda time=========="+dateTime.toString("E MM/dd/yyyy HH:mm:ss.SSS"));
	}
	
	
	@Test
	public void testAddCalendarTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/yyyy HH:mm:ss.SSS");
		calendar.add(Calendar.DAY_OF_MONTH, 90);
		System.out.println("calendar add 90====="+sdf.format(calendar.getTime()));
		
		DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
		System.out.println("jodatime add 90====="+dateTime.plusDays(90).toString("E MM/dd/yyyy HH:mm:ss.SSS"));
		 
	}
	
	
}
