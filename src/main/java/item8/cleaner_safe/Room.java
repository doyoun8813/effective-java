package item8.cleaner_safe;

import java.lang.ref.Cleaner;

// try with resource와 cleaner를 안전망으로 사용하는 클래스
public class Room implements AutoCloseable {
	
	// Cleaner 생성
	private static final Cleaner cleaner = Cleaner.create();
	
	// 청소가 필요한 자원 및 자원 정리 작업 Task. Room 참조 금지
	private static class State implements Runnable {
		
		int numJunkPiles;
		
		State(int numJunkPiles) { this.numJunkPiles = numJunkPiles; }
		
		// close 메서드나 cleaner가 호출
		@Override
		public void run() {
			System.out.println("Cleaning room");
			numJunkPiles = 0;
		}
	}
	
	// 방의 상태. cleanable과 공유
	private final State state;
	
	//cleanable 객체. 수거 대상이 되면 방을 청소한다.
	private final Cleaner.Cleanable cleanable;
	
	public Room(int numJunkPiles) {
		state = new State(numJunkPiles);
		cleanable = cleaner.register(this, state);
	}

	@Override
	public void close() {
		cleanable.clean();		
	}
	
}
