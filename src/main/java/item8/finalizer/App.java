package item8.finalizer;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub

		int i = 0;
		while(true) {
			i++;
			// FinalizerIsBad 객체가 가비지컬렉션 대상이 되면 finalize() 메서드가 실행된다.
			// 해당 객체는 레퍼런스 큐에 담긴다.
			new FinalizerIsBad();
			
			// 백만번째 실행할 때 마다 Finalizer 큐에 얼마나 많은 객체들이 쌓여있는지 확인하는 코드
			if((i % 1_000_000) == 0) {
				
				Class<?> finalizerClass = Class.forName("java.lang.ref.Finalizer");
				Field queueStaticField = finalizerClass.getDeclaredField("queue");
				queueStaticField.setAccessible(true);
				ReferenceQueue<Object> referenceQueue = (ReferenceQueue) queueStaticField.get(null);
				
				Field queueLengthField = ReferenceQueue.class.getDeclaredField("queueLength");
				queueLengthField.setAccessible(true);
				long queueLength = (long) queueLengthField.get(referenceQueue);
				System.out.format("There are %d references in the queue%n", queueLength);
			}
			
		}// end of loop
		
	}// end of main

}// end of class
