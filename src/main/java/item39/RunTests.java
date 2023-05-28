package item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName("item39.Sample");
		for (Method m : testClass.getDeclaredMethods()) {
			if(m.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + " ����:" + exc);
				} catch (Exception exc) {
					System.out.println("�߸� ����� @Test: " + m);
				}
			}
		}
		
		System.out.printf("����: %d, ����: %d%n", passed, tests - passed);
		
	}

}
