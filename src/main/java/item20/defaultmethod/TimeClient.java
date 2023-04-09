package item20.defaultmethod;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface TimeClient {

	void setTime(int hour, int minute, int second);
	void setDate(int day, int month, int year);
	void setDateAndTime(int day, int month, int year, int hour, int minute, int second);
	
	LocalDateTime getLocalDateTime();
	
	//추가한 추상 메서드
	//ZonedDateTime getZonedDateTime(String zoneString);
	
	//디폴트 메서드로 변경
	default ZonedDateTime getZonedDateTime(String zoneString) {
		return ZonedDateTime.of(getLocalDateTime(), getZonedId(zoneString));
	}
	
	static ZoneId getZonedId(String zoneString) {
		try {
			return ZoneId.of(zoneString);
		} catch (DateTimeException e) {
			System.err.println("Invalid time zone : " + zoneString + "; using default time zone instead.");
			return ZoneId.systemDefault();
		}
	}
}
