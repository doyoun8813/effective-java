package item14;

import java.math.BigDecimal;

public class compareToConvention {

	public static void main(String[] args) {
		BigDecimal n1 = BigDecimal.valueOf(2312342);
		BigDecimal n2 = BigDecimal.valueOf(1234345);
		BigDecimal n3 = BigDecimal.valueOf(6757654);
		BigDecimal n4 = BigDecimal.valueOf(1234345);
		
		// �ݻ缺
		// x.compareTo(x) == 0
		System.out.println(n1.compareTo(n1));
		
		// ��Ī��
		// x.compareTo(y) == y.compareTo(x)

		System.out.println(n2.compareTo(n1));
		System.out.println(n1.compareTo(n2));
		
		// ���̼�
		// x.compareTo(y) > 0 && y.compareTo(z) > 0 �̸� x.compareTo(z) > 0
		System.out.println(n3.compareTo(n1) > 0);
		System.out.println(n1.compareTo(n2) > 0);
		System.out.println(n3.compareTo(n2) > 0);
		
		// �ϰ���
		// x.compareTo(y) == 0 �̸� (x.compareTo(z) == y.compareTo(z))
		System.out.println(n4.compareTo(n2));
		System.out.println(n2.compareTo(n1));
		System.out.println(n4.compareTo(n1));
		
		// compareTo�� 0 �̶�� equals�� true���� �Ѵ�. �ƴҼ��� �ִ�
		// (x.compareTo(y) == 0) == (x.equals(y))
		BigDecimal oneZero = new BigDecimal("1.0");
		BigDecimal oneZeroZero = new BigDecimal("1.00");
		// Tree�� TreeMap���� ���� ���ٰ� �������̵� �ż� �� �� �ϳ��ۿ� �ȵ���.
		System.out.println(oneZero.compareTo(oneZeroZero));
		// ������ ���� �÷����� ��� �ٸ� ������ �������̵� �ż� false�� ���´�.
		// �Ҽ��� ���ڸ����� �� �˻��Ѵ�.
		System.out.println(oneZero.equals(oneZeroZero));
		
	} // end of main
	
} // end of class
