package item16.dimension;

import java.awt.Button;
import java.awt.Dimension;

public class DimensionExample {

	public static void main(String[] args) {
		Button button = new Button("Hello Button");
		button.setBounds(0, 0, 20, 10);
		
		// ��Ű�� �ۿ��� Demension �ʵ�� �����Ͽ� ���� ����ϸ�
		// ���� ��� ������� �� �� ������
		// �ٸ� ������ �����ϰ� ����Ϸ��� ����ϴ� ������ Demension�� �����Ͽ�
		// ������ �������� ������ ����ؾ� �Ѵ�.
		// �̷��� ���縦 �ϰԵǴ� ���� ������ �̷������ ���ɵ� ������ ����.
		Dimension size = button.getSize();
		System.out.println(size.height);
		System.out.println(size.width);
		
		doSomething(size);
	}
	
	private static void doSomething(Dimension dimension) {
		// �̷��� ���� ������ �� �ִµ� ���� �ʱⰪ���� ���õ� ���� �ٸ��ٸ�
		// �������� �ǵ��� �ٸ��� ������ �� �ִ�.
		// dimension.width = 10;
		
		// �����ϰ� �����Ͽ� ��� ������ primitive ���̶� ���� ���� ��
		
		
		Dimension dimension2 = new Dimension();
		dimension2.height = dimension.height;
		dimension2.width = dimension.width;
		
	}
}
