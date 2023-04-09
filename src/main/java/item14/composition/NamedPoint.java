package item14.composition;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class NamedPoint implements Comparable<NamedPoint>{
	
	// 상속을 사용해서 필드값이 추가될 경우 compareTo 규약을 지킬 수 없으니
	// Composition을 사용하라
	
	private final Point point;
	private final String name;
	
	public NamedPoint(Point point, String name) {
		this.point = point;
		this.name = name;
	}
	
	// 뷰 제공
	public Point getPoint() {
		return this.point;
	}

	@Override
	public int compareTo(NamedPoint namedPoint) {
		// 가져온 Point 먼저 비교 하고
		int result = this.point.compareTo(namedPoint.point);
		// 후에 추가한 필드 비교
		if(result == 0) {
			result = this.name.compareTo(namedPoint.name);
		}
		return result;
	}	
	
}
