package item20.skeleton;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class InitArrays {

	public InitArrays() {
		
	}
	
	static List<Integer> intArrayAsList(int[] a) {
		Objects.requireNonNull(a);
		
		return new AbstractList<>() {

			@Override
			public Integer get(int index) {
				return a[index];
			}

			@Override
			public Integer set(int index, Integer element) {
				int oldVal = a[index];
				a[index] = element;
				return oldVal;
			}

			@Override
			public int size() {
				return a.length;
			}
			
		};
	}

	public static void main(String[] args) {
		int [] a = new int[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		
		List<Integer> list = intArrayAsList(a);
		Collections.shuffle(list);
		System.out.println(list);
	}
}
