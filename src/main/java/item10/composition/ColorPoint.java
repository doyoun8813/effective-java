package item10.composition;

import java.util.Objects;

import item10.Color;
import item10.Point;

public class ColorPoint {
	
	private final Point point;
	private final Color color;
	
	public ColorPoint(int x, int y, Color color) {
		point = new Point(x, y);
		this.color = Objects.requireNonNull(color);
	}
	
	// ColorPoint¿« ∫‰∏¶ π›»Ø
	public Point asPoint() { 
		return point; 
		}

	@Override
	public int hashCode() {
		return 31 + point.hashCode() + color.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ColorPoint))
			return false;
		
		ColorPoint cp = (ColorPoint) obj;
		
		return cp.point.equals(point) && cp.color.equals(color);
	}
	
	public static void main(String[] args) {
			
			//Point p = new Point(1, 2);
			//ColorPoint cp = new ColorPoint(1, 2, Color.RED);
			//System.out.println(p.equals(cp) + " " + cp.equals(p)); 
			
			ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
			Point p2 = new Point(1, 2);
			ColorPoint cp2 = new ColorPoint(1, 2, Color.BLUE);
			
			System.out.printf("%s %s %s%n", cp1.equals(p2), p2.equals(cp2), cp1.equals(cp2));
			
	}// end of main	

}// end of class
