package item16.point.field;

public class Point {

	public double x;
	public double y;
	
	public static void main(String[] args) {
		Point point = new Point();
		// 필드에 직접 접근하여 사용하지 마라
		// 캡슐화의 장점이 없다.
		// 필드의 이름이 변경된다면 필드 이름으로 접근하여 사용한 모든 곳을 고쳐줘야 한다.
		// 값을 받을 때 유효성 검사를 할 수 없다
		point.x = 10;
		point.y = 20;
		
		System.out.println(point.x);
		System.out.println(point.y);
		
	}
	
}
