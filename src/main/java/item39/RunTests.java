package item39;

import java.lang.reflect.Method;

public class RunTests {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName("item39.Sample2");
		for (Method m : testClass.getDeclaredMethods()) {
			if(m.isAnnotationPresent(ExceptionTest.class) 
					|| m.isAnnotationPresent(ExceptionTestContainer.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("�׽�Ʈ %s ����: ���ܸ� ������ ����%n", m);
				} catch (Throwable wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					int oldPassed = passed;
					ExceptionTest[] excTests = m.getAnnotationsByType(ExceptionTest.class);
					for (ExceptionTest excTest : excTests) {
						if(excTest.value().isInstance(exc)) {
							passed++;
							break;
						}
					}
					if (passed == oldPassed) {
						System.out.printf("�׽�Ʈ %s ����: %s %n ", m, exc);
					}					
				}
			}
		}
		System.out.printf("����: %d, ����: %d%n", passed, tests - passed);		
	}
}
