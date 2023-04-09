package item19.constructor;

import java.time.Instant;

public final class Sub extends Super {
	
	// �ʱ�ȭ���� ���� final �ʵ�. �����ڿ��� �ʱ�ȭ �ȴ�.
	private final Instant instant;

	Sub() {
		// ������ �޼��� ù������ ���������� super() Ŭ���� �����ڸ� ȣ���Ѵ�.
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
