package item28;

import java.util.List;

public class SafeArgsExample{
	
	static void notSafe(List<String>... strLists) {
		Object[] array = strLists; // List<String>... => List[], �迭�� ����
		List<Integer> tmpList = List.of(42);
		array[0] = tmpList; // Object �迭�� ���ڰ� ��� ����Ʈ�� �־��µ�
		String s = strLists[0].get(0); // String���� ĳ���� ���� �ʴ´�. ����!
	}
	
	@SafeVarargs
	static <T> void safe(T... values) {
		for (T value : values) {
			System.out.println(value);
		}
	}
	
	public static void main(String[] args) {
//		Fruit.safe("a", "b", "c");
//		Fruit.notSafe(List.of("a", "b", "c"));
	}

}
