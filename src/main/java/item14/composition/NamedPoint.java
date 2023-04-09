package item14.composition;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class NamedPoint implements Comparable<NamedPoint>{
	
	// ����� ����ؼ� �ʵ尪�� �߰��� ��� compareTo �Ծ��� ��ų �� ������
	// Composition�� ����϶�
	
	private final Point point;
	private final String name;
	
	public NamedPoint(Point point, String name) {
		this.point = point;
		this.name = name;
	}
	
	// �� ����
	public Point getPoint() {
		return this.point;
	}

	@Override
	public int compareTo(NamedPoint namedPoint) {
		// ������ Point ���� �� �ϰ�
		int result = this.point.compareTo(namedPoint.point);
		// �Ŀ� �߰��� �ʵ� ��
		if(result == 0) {
			result = this.name.compareTo(namedPoint.name);
		}
		return result;
	}	
	
}
