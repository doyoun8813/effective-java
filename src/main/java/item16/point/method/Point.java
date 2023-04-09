package item16.point.method;

public class Point {

	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// �ʵ� �̸��� ����Ǵ��� �޼��� �̸��� ����
	public double getX() {
		// �ΰ��۾� ����. �� ��ȿ�� �˻�
		return x; 
	}
	
	// ��Ű�� ���ο����� ���� ������ ���ٸ� package-private ���� ������ ���
	public double getY() { return y; }
	
	public void setX(double x) { 
		// �� �����۾� ����
		this.x = x; 
	}
	
	// �� �� ������ ���� ������� �ʰ� �Ϸ��� set �޼ҵ� ���� ���ϸ� ��
	public void setY(double y) { 
		this.y = y; 
	}
	
}
