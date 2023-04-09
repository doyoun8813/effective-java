package item19.constructor;

import java.time.Instant;

public final class Sub extends Super {
	
	// 초기화되지 않은 final 필드. 생성자에서 초기화 된다.
	private final Instant instant;

	Sub() {
		// 생성자 메서드 첫라인은 내부적으로 super() 클래스 생성자를 호출한다.
		instant = Instant.now();
	}
	
	@Override 
	public void overrideMe() {
		System.out.println(instant);
	}

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overrideMe();
	}

}
