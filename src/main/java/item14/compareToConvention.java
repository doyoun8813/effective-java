package item14;

import java.math.BigDecimal;

public class compareToConvention {

	public static void main(String[] args) {
		BigDecimal n1 = BigDecimal.valueOf(2312342);
		BigDecimal n2 = BigDecimal.valueOf(1234345);
		BigDecimal n3 = BigDecimal.valueOf(6757654);
		BigDecimal n4 = BigDecimal.valueOf(1234345);
		
		// 반사성
		// x.compareTo(x) == 0
		System.out.println(n1.compareTo(n1));
		
		// 대칭성
		// x.compareTo(y) == y.compareTo(x)

		System.out.println(n2.compareTo(n1));
		System.out.println(n1.compareTo(n2));
		
		// 추이성
		// x.compareTo(y) > 0 && y.compareTo(z) > 0 이면 x.compareTo(z) > 0
		System.out.println(n3.compareTo(n1) > 0);
		System.out.println(n1.compareTo(n2) > 0);
		System.out.println(n3.compareTo(n2) > 0);
		
		// 일관성
		// x.compareTo(y) == 0 이면 (x.compareTo(z) == y.compareTo(z))
		System.out.println(n4.compareTo(n2));
		System.out.println(n2.compareTo(n1));
		System.out.println(n4.compareTo(n1));
		
		// compareTo가 0 이라면 equals는 true여야 한다. 아닐수도 있다
		// (x.compareTo(y) == 0) == (x.equals(y))
		BigDecimal oneZero = new BigDecimal("1.0");
		BigDecimal oneZeroZero = new BigDecimal("1.00");
		// Tree나 TreeMap에서 사용시 같다고 오버라이딩 돼서 둘 중 하나밖에 안들어간다.
		System.out.println(oneZero.compareTo(oneZeroZero));
		// 순서가 없는 컬렉션일 경우 다른 것으로 오버라이딩 돼서 false가 나온다.
		// 소수점 뒷자리까지 비교 검사한다.
		System.out.println(oneZero.equals(oneZeroZero));
		
	} // end of main
	
} // end of class
