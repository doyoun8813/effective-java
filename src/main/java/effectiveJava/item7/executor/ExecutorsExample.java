package effectiveJava.item7.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {

	public static void main(String[] args) {
		
		// 스레드풀에 스레드를10개 만들어 100개의 작업을 돌림
		ExecutorService service = Executors.newFixedThreadPool(10);
		// 필요한 만큼 스레드를 돌림 무한정 스레드를 생성할 수 있으니 조심
		ExecutorService service2 = Executors.newCachedThreadPool();
		// 한 개의 스레드로 작업 처리
		ExecutorService service3 = Executors.newSingleThreadExecutor();
		// 작업을 딜레이시켜서 실행하거나 주기적으로 실행시킬 때
		ExecutorService service4 = Executors.newScheduledThreadPool(10);
		
		for (int i = 0; i < 100; i++) {
			service.submit(new Task());		
		}
		
		System.out.println(Thread.currentThread() + " hello");
		
		service.shutdown();
		
	}// end of main

	
	static class Task implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread() + " world");
			
		}		
		
	}// end of class
	
}// end of class
