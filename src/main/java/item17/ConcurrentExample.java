package item17;

import java.util.concurrent.CountDownLatch;

public class ConcurrentExample {

	public static void main(String[] args) throws InterruptedException {
		// �ӽ��� ������ ����
		int N = 10;
		// 1�ʺ��� ī��Ʈ�ٿ� �� �ٷ� 0�� �ȴ�.
		CountDownLatch startSignal = new CountDownLatch(1);
		// �������� ������ 10�Ҵ�. 10���� ī��� �ٿ� �ȴ�.
		CountDownLatch doneSignal = new CountDownLatch(N);
		
		// 10���� ������ ����
		for (int i = 0; i < N; i++) {
			new Thread(new Worker(startSignal, doneSignal)).start();
		}
		
		ready();
		// startSignal ī��Ʈ�ٿ� ����
		startSignal.countDown();
		// doneSignal�� 0�� �� ������ ��ٸ���.
		doneSignal.await();
		done();
	}
	
	private static void ready() {
		System.out.println("�غ�");
	}
	
	private static void done() {
		System.out.println("��");
	}
	
	private static class Worker implements Runnable {
		
		private final CountDownLatch startSignal;
		private final CountDownLatch doneSignal;
		
		public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
			this.startSignal = startSignal;
			this.doneSignal = doneSignal;
		}
		
		public void run() {
			try {
				// startSignal�� 0�� �� ������ ��ٸ���.
				startSignal.await();
				doWork();
				// doneSignal ī��Ʈ�ٿ� ����
				doneSignal.countDown();
			} catch (InterruptedException ex) {}
		}
		
		void doWork() {
			System.out.println("working thread : " + Thread.currentThread().getName());
		}
	}
}
