package item8.cleaner_safe;

import java.lang.ref.Cleaner;

// try with resource�� cleaner�� ���������� ����ϴ� Ŭ����
public class Room implements AutoCloseable {
	
	// Cleaner ����
	private static final Cleaner cleaner = Cleaner.create();
	
	// û�Ұ� �ʿ��� �ڿ� �� �ڿ� ���� �۾� Task. Room ���� ����
	private static class State implements Runnable {
		
		int numJunkPiles;
		
		State(int numJunkPiles) { this.numJunkPiles = numJunkPiles; }
		
		// close �޼��峪 cleaner�� ȣ��
		@Override
		public void run() {
			System.out.println("Cleaning room");
			numJunkPiles = 0;
		}
	}
	
	// ���� ����. cleanable�� ����
	private final State state;
	
	//cleanable ��ü. ���� ����� �Ǹ� ���� û���Ѵ�.
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
