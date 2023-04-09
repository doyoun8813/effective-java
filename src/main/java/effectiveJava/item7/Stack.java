package effectiveJava.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
	
	private static Object[] elements;
	private static int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY  = 16;
	
	// 클래스 생성하면 elements 배열에 16개의 방이 초기화
	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	// elements에 인자값 넣기 후치 증감 연산자로 0부터 차례로 들어간다.
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	// elements 배열에 참조된 값 가져오기 전치 감소 연산자로 늘어난 size값을 -1하여 마지막 배열 값부터 가져온다.
	// 단순 값을 가져오는 것일 뿐 배열의 방을 빼는건 아니다.
	/*public Object pop() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		
		return elements[--size];
	}*/
	
	// elements 배열에 참조된 값 가져오기 전치 감소 연산자로 늘어난 size값을 -1하여 마지막 배열 값부터 가져온다.
	// 값을 가져오는 동시에 해당 배열의 방을 참조 해제해준다.
	public Object pop() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		
		Object result = elements[--size];
		elements[size] = null; // 참조 해제
		return result;
	}
	
	// 기본 16개 배열의 방이 꽉 차면 방을 2배로 늘려준다.
	public void ensureCapacity() {
		if(elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	public static Object getElement(int idx) {
		return elements[idx];
	}
	
	// elements 배열 방의 갯수를 알려준다.
	public static int getElementsLength() {
		return elements.length;
	}
	
	
	public static int getSize() {
		return size;
	}
	
	
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
		
		System.out.println("Stack size : " + getSize());
		System.out.println("Stack elements length : " + getElementsLength());
		System.out.println("Stack elements[0] : " + getElement(0));
				

	}// end of main

	

}// end of class
