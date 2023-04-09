package item8.finalizer;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub

		int i = 0;
		while(true) {
			i++;
			// FinalizerIsBad ��ü�� �������÷��� ����� �Ǹ� finalize() �޼��尡 ����ȴ�.
			// �ش� ��ü�� ���۷��� ť�� ����.
			new FinalizerIsBad();
			
			// �鸸��° ������ �� ���� Finalizer ť�� �󸶳� ���� ��ü���� �׿��ִ��� Ȯ���ϴ� �ڵ�
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
