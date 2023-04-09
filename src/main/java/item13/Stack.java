package item13;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack implements Cloneable {
	
	private Object[] elements;
	private int size = 0;
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
	
	public boolean isEmpty() { return size == 0; }
		
	@Override
	public Stack clone() {
		try {
			Stack result = (Stack) super.clone();
			// ������ �� elements�� ���� ����
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
		
		// ������ stack���� ������ �� Primitive Type�� size�� �������� ������ �Ǵ��� ���纻�� ������ ���� �ʾƼ�
		// while���� 2�� ������ �̹� �������� �迭�� pop �ؼ� ������ ã�ƺ� �� ����.
		System.out.println("pop of copy");
		while (!copy.isEmpty()) {
			System.out.println(copy.pop() + " ");
		}
		
		System.out.println(stack.elements[0] ==copy.elements[0]);

	}// end of main	

}// end of class
