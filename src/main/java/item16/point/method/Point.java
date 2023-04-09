package item16.point.method;

public class Point {

	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// 필드 이름이 변경되더라도 메서드 이름은 유지
	public double getX() {
		// 부가작업 가능. 값 유효성 검사
		return x; 
	}
	
	// 패키지 내부에서만 값을 가져다 쓴다면 package-private 접근 제어자 사용
	public double getY() { return y; }
	
	public void setX(double x) { 
		// 값 검증작업 가능
		this.x = x; 
	}
	
	// 한 번 지정된 값이 변경되지 않게 하려면 set 메소드 제공 안하면 됨
	public void setY(double y) { 
		this.y = y; 
	}
	
}
