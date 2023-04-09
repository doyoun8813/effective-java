package item10.inheritance;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

import item10.Color;
import item10.Point;

public class CounterPointTest {
	
	private static final Set<Point> unitCircle = Set.of(
			new Point(1, 0), new Point (0, 1),
			new Point(-1, 0), new Point(0, -1));
	
	public static boolean onUnitCircle(Point p) {
		return unitCircle.contains(p);
	}
			

	public static void main(String[] args) {
		
		Point p1 = new Point(1, 0);
		Point p2 = new CounterPoint(1, 0);
		Point p3 = new item10.composition.ColorPoint(1, 0, Color.RED).asPoint();
		
		System.out.println(onUnitCircle(p1));		
		System.out.println(onUnitCircle(p2));
		System.out.println(onUnitCircle(p3));
	}
}
