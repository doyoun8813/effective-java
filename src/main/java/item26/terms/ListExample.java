package item26.terms;

import java.util.Arrays;

public class ListExample {
	
	private int size;
	
	Object[] elements;
	
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			
			/**
			 * 왜 선언 했는지 상세히 남겨둔다.
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
