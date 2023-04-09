package item20.defaultmethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collection;

public class SimpleTimeClient implements TimeClient, AutoCloseable {
	
	private LocalDateTime dateAndTime;

	public SimpleTimeClient() {
		dateAndTime = LocalDateTime.now();
	}

	public void setTime(int hour, int minute, int second) {
		LocalDate currentDate = LocalDate.from(dateAndTime);
		LocalTime timeToSet = LocalTime.of(hour, minute, second);
		dateAndTime = LocalDateTime.of(currentDate, timeToSet);
	}

	public void setDate(int day, int month, int year) {
		LocalDate dateToSet = LocalDate.of(year, month, month);
		LocalTime currentTime = LocalTime.from(dateToSet);
		dateAndTime = LocalDateTime.of(dateToSet, currentTime);
	}

	public void setDateAndTime(int day, int month, int year, int hour, int minute, int second) {
		LocalDate dateToSet = LocalDate.of(day, month, year);
		LocalTime timeToSet = LocalTime.of(hour, minute, second);
		dateAndTime = LocalDateTime.of(dateToSet, timeToSet);
	}

	public LocalDateTime getLocalDateTime() {
		return dateAndTime;
	}
	
	@Override
	public String toString() {
		return dateAndTime.toString();
	}
	
	public static void main(String[] args) {
		TimeClient myTimeclient = new SimpleTimeClient();
		System.out.println(myTimeclient);
		System.out.println(myTimeclient.getZonedDateTime("Asia/Seoul"));
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
	}

}
