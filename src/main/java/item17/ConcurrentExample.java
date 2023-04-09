package item17;

import java.util.concurrent.CountDownLatch;

public class ConcurrentExample {

	public static void main(String[] args) throws InterruptedException {
		// 임시의 스레드 숫자
		int N = 10;
		// 1초부터 카운트다운 시 바로 0이 된다.
		CountDownLatch startSignal = new CountDownLatch(1);
		// 스레드의 갯수인 10할당. 10부터 카운드 다운 된다.
		CountDownLatch doneSignal = new CountDownLatch(N);
		
		// 10개의 스레드 생성
		for (int i = 0; i < N; i++) {
			new Thread(new Worker(startSignal, doneSignal)).start();
		}
		
		ready();
		// startSignal 카운트다운 시작
		startSignal.countDown();
		// doneSignal이 0이 될 때까지 기다린다.
		doneSignal.await();
		done();
	}
	
	private static void ready() {
		System.out.println("준비");
	}
	
	private static void done() {
		System.out.println("끝");
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
				// startSignal이 0이 될 때까지 기다린다.
				startSignal.await();
				doWork();
				// doneSignal 카운트다운 시작
				doneSignal.countDown();
			} catch (InterruptedException ex) {}
		}
		
		void doWork() {
			System.out.println("working thread : " + Thread.currentThread().getName());
		}
	}
}
