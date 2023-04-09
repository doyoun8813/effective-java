package item14.composition;

public class Point implements Comparable<Point> {
	
	private final int x;
	private final int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Point)) {
			return false;
		}
		
		Point p = (Point) obj;
		return p.x == x && p.y == y;
	}
		
	@Override
	public int compareTo(Point point) {
		int result = Integer.compare(this.x, point.x);
		if(result == 0) {
			result = Integer.compare(this.y, point.y);
		}
		return result;
	}

	@Override
	public int hashCode() {
		return 31 * x + y;
	}
	
}
