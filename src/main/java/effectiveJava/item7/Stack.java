package effectiveJava.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
	
	private static Object[] elements;
	private static int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY  = 16;
	
	// Ŭ���� �����ϸ� elements �迭�� 16���� ���� �ʱ�ȭ
	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	// elements�� ���ڰ� �ֱ� ��ġ ���� �����ڷ� 0���� ���ʷ� ����.
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	// elements �迭�� ������ �� �������� ��ġ ���� �����ڷ� �þ size���� -1�Ͽ� ������ �迭 ������ �����´�.
	// �ܼ� ���� �������� ���� �� �迭�� ���� ���°� �ƴϴ�.
	/*public Object pop() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		
		return elements[--size];
	}*/
	
	// elements �迭�� ������ �� �������� ��ġ ���� �����ڷ� �þ size���� -1�Ͽ� ������ �迭 ������ �����´�.
	// ���� �������� ���ÿ� �ش� �迭�� ���� ���� �������ش�.
	public Object pop() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		
		Object result = elements[--size];
		elements[size] = null; // ���� ����
		return result;
	}
	
	// �⺻ 16�� �迭�� ���� �� ���� ���� 2��� �÷��ش�.
	public void ensureCapacity() {
		if(elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	public static Object getElement(int idx) {
		return elements[idx];
	}
	
	// elements �迭 ���� ������ �˷��ش�.
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
