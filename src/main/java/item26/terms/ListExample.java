package item26.terms;

import java.util.Arrays;

public class ListExample {
	
	private int size;
	
	Object[] elements;
	
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			
			/**
			 * �� ���� �ߴ��� ���� ���ܵд�.
			 */
			@SuppressWarnings("unchecked")
			T[] result = (T[])Arrays.copyOf(elements, size, a.getClass());
			
			return result;
		}
		
		System.arraycopy(elements, 0, a, 0, size);
		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}
	
	public static void main(String[] args) {
		
	}

}
