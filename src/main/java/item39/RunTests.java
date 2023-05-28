package item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName("item39.Sample2");
		for (Method m : testClass.getDeclaredMethods()) {
			if(m.isAnnotationPresent(ExceptionTest.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("�׽�Ʈ %s ����: ���ܸ� ������ ����%n", m);
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					Class<? extends Throwable> excType = 
							m.getAnnotation(ExceptionTest.class).value();
					if(excType.isInstance(exc)) {
						passed++;
					}else {
						System.out.printf("�׽�Ʈ %s ����: ����� ���� %s,\n �߻��� ���� %s%n", m, excType.getName(), exc);					
					}
				} catch (Exception exc) {
					System.out.println("�߸� ����� @ExceptionTest: " + m);
				}
			}
		}
		System.out.printf("����: %d, ����: %d%n", passed, tests - passed);		
	}
}
