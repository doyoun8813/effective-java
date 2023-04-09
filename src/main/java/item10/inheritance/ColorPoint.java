package item10.inheritance;

import item10.Color;
import item10.Point;

public class ColorPoint extends Point {
	
	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}
	
	// ��Ī�� ����
//	@Override
//	public boolean equals(Object obj) {
//		if(!(obj instanceof ColorPoint))
//			return false;
//		return super.equals(obj) && ((ColorPoint) obj).color == color;
//	}
	
	// ���̼� ����
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Point)) {
			return false;
		}			
		
		// obj�� PointŸ���̸� ������ �����ϰ� ��
		// ColorPoint Ÿ�԰� ���� ������ Point ���� Ŭ������ �ִٴ� �����Ͽ�
		// �ش� Ŭ���� equals �޼��� ���ο��� �Ʒ��� ���� �ڵ尡 �ִٸ�
		// ���� ��Ϳ� ���� StackOverFlowError�� ����Ų��
		// ������ equals �޼��尡 ��� ����Ǳ� ����
		if(!(obj instanceof ColorPoint)) {
			return obj.equals(this);
		}
			
		// obj�� ColorPoint�� ������� ��
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
