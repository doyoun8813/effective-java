package item16.time;

// public Ŭ������ ��� ��� ��Ű������ �ش� Ŭ������ ���ٰ� ����ߴ��� �˱� ��Ʊ� ������
// �ܺο��� ����ϴ� Ŭ������ �ƴ϶�� package-private Ŭ������ ������
public class Time {
	
	private static final int HOUR_PER_DAY = 24;
	private static final int MINUTES_PER_HOUR = 60;
	
	// �ܺο��� ���� ������ �ʵ������� �׳��� final�� �ʱⰪ ������ �Ǹ� ������ �� ���� �����.
	// public ���� �ʵ��� ���� ��������� ���� ����� ������ �ִ�.
	// ������ �ٱ� ������ API�� �������� �ʰ� ǥ�� ����� �ٲ� �� ����
	// �ʵ带 ���� �� �ΰ��۾��� �� �� ����.
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
