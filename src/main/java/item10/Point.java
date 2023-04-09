package item10;

public class Point {
	
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
		
		//System.out.println(obj.getClass());
		//System.out.println(getClass());
		
//		if(obj == null || obj.getClass() != getClass())
//			return false;
//		
//		Point p = (Point) obj;
//		return p.x == x && p.y == y;
	}
		
	@Override
	public int hashCode() {
		return 31 * x + y;
	}
	
}
