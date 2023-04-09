package item13;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack implements Cloneable {
	
	private Object[] elements;
	private int size = 0;
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
	
	public boolean isEmpty() { return size == 0; }
		
	@Override
	public Stack clone() {
		try {
			Stack result = (Stack) super.clone();
			// 복사할 떄 elements도 같이 복사
			result.elements = elements.clone();
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	public static void main(String[] args) {		
		
		Object[] values = new Object[2];
		values[0] = new PhoneNumber(123, 456, 7890);
		values[1] = new PhoneNumber(321, 654, 987);
		
		Stack stack = new Stack();
		
		for (Object arg : values) {
			stack.push(arg);
		}
		
		Stack copy = stack.clone();
		
		System.out.println("pop from stack");
		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " ");
		}
		
		// 원본인 stack에서 복사할 때 Primitive Type인 size는 원본에서 변경이 되더라도 복사본에 영향이 가지 않아서
		// while문이 2번 돌지만 이미 원본에서 배열을 pop 해서 내용을 찾아볼 수 없다.
		System.out.println("pop of copy");
		while (!copy.isEmpty()) {
			System.out.println(copy.pop() + " ");
		}
		
		System.out.println(stack.elements[0] ==copy.elements[0]);

	}// end of main	

}// end of class
