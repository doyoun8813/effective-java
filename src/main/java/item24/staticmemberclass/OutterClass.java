package item24.staticmemberclass;

public class OutterClass {

	private static int number = 10;
	
	// static member class
	static private class InnerClass {
		void doSomething() {
			System.out.println(number);
		}
	}
	
	public static void main(String[] args) {
		InnerClass innerClass = new InnerClass();
		innerClass.doSomething();
	}

}
