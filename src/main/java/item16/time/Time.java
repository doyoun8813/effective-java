package item16.time;

// public 클래스의 경우 어느 패키지에서 해당 클래스를 갖다가 사용했는지 알기 어렵기 떄문에
// 외부에서 사용하는 클래스가 아니라면 package-private 클래스로 만들어라
public class Time {
	
	private static final int HOUR_PER_DAY = 24;
	private static final int MINUTES_PER_HOUR = 60;
	
	// 외부에서 접근 가능한 필드이지만 그나마 final로 초기값 세팅이 되면 변경할 수 없게 만든다.
	// public 가변 필드라면 언제 어느시점에 값이 변경될 위험이 있다.
	// 단점이 줄긴 하지만 API를 변경하지 않고 표현 방식을 바꿀 수 없고
	// 필드를 읽을 때 부가작업을 할 수 없다.
	public final int hour;
	public final int minute;
	
	public Time(int hour, int minute) {
		if (hour < 0 || hour >= HOUR_PER_DAY)
			throw new IllegalArgumentException("Hour : " + hour);
		if (minute < 0 || minute >= MINUTES_PER_HOUR)
			throw new IllegalArgumentException("Min : " + minute);
		this.hour = hour;
		this.minute = minute;
	}
	
}
