package effectiveJava.item7.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {

	public static void main(String[] args) {
		
		// ������Ǯ�� �����带10�� ����� 100���� �۾��� ����
		ExecutorService service = Executors.newFixedThreadPool(10);
		// �ʿ��� ��ŭ �����带 ���� ������ �����带 ������ �� ������ ����
		ExecutorService service2 = Executors.newCachedThreadPool();
		// �� ���� ������� �۾� ó��
		ExecutorService service3 = Executors.newSingleThreadExecutor();
		// �۾��� �����̽��Ѽ� �����ϰų� �ֱ������� �����ų ��
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
