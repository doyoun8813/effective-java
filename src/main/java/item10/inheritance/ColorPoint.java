package item10.inheritance;

import item10.Color;
import item10.Point;

public class ColorPoint extends Point {
	
	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}
	
	// 대칭성 위배
//	@Override
//	public boolean equals(Object obj) {
//		if(!(obj instanceof ColorPoint))
//			return false;
//		return super.equals(obj) && ((ColorPoint) obj).color == color;
//	}
	
	// 추이성 위배
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Point)) {
			return false;
		}			
		
		// obj가 Point타입이면 색상을 무시하고 비교
		// ColorPoint 타입과 같은 레벨의 Point 서브 클래스가 있다는 가정하에
		// 해당 클래스 equals 메서드 내부에도 아래와 같은 코드가 있다면
		// 무한 재귀에 빠져 StackOverFlowError를 일으킨다
		// 각각의 equals 메서드가 계속 실행되기 때문
		if(!(obj instanceof ColorPoint)) {
			return obj.equals(this);
		}
			
		// obj가 ColorPoint면 색상까지 비교
		return super.equals(obj) && ((ColorPoint) obj).color == color;
	}

	public static void main(String[] args) {
		
//		Point p = new Point(1, 2);
//		ColorPoint cp = new ColorPoint(1, 2, Color.RED);
//		System.out.println(p.equals(cp) + " " + cp.equals(p)); 
		
		ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
		Point p2 = new Point(1, 2);
		ColorPoint cp2 = new ColorPoint(1, 2, Color.BLUE);
		
		System.out.printf("%s %s %s%n", cp1.equals(p2), p2.equals(cp2), cp1.equals(cp2));
		
	}// end of main

}// end of class
