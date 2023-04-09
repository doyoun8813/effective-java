package effectiveJava.item7;

public class App {
	
	
	public static void main(String[] args) {		
			
		Stack stack = new Stack();
		
		System.out.println("Stack size : " + stack.getSize());
		System.out.println("Stack elements length : " + stack.getElementsLength());
		System.out.println("Stack elements[0] : " + stack.getElement(0));
		
		System.out.println("-------------------------------");
		
		stack.push("hello1");
		stack.push("hello2");
		stack.push("hello3");
		stack.push("hello4");
		stack.push("hello5");
		stack.push("hello6");
		stack.push("hello7");
		stack.push("hello8");
		stack.push("hello9");
		stack.push("hello10");
		stack.push("hello11");
		stack.push("hello12");
		stack.push("hello13");
		stack.push("hello14");
		stack.push("hello15");
		stack.push("hello16");
		stack.push("hello17");
		
		System.out.println("Stack size : " + stack.getSize());
		System.out.println("Stack elements length : " + stack.getElementsLength());
		System.out.println("Stack elements[size] : " + stack.getElement(0));
		
		System.out.println("-------------------------------");
		
		System.out.println(stack.pop());
		
		System.out.println("-------------------------------");
		
		System.out.println("Stack size : " + stack.getSize());
		System.out.println("Stack elements length : " + stack.getElementsLength());
		System.out.println("Stack elements[size] : " + stack.getElement(stack.getSize()));
		
		stack = null;
		System.gc();
		
		System.out.println("Stack size : " + stack.getSize());
		System.out.println("Stack elements length : " + stack.getElementsLength());
		System.out.println("Stack elements[0] : " + stack.getElement(0));
				

	}// end of main

}
