package item24.memberclass;

public class OutterClass {

	// member class
	private class InnerClass {
		private int number = 10;
		
		void doSomething() {
			System.out.println(number);
		}
	}
	
	public static void main(String[] args) {
		InnerClass innerClass = new OutterClass().new InnerClass();
		innerClass.doSomething();
	}

}
