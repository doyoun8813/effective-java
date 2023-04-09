package item28;

import java.util.List;

public class SafeArgsExample{
	
	static void notSafe(List<String>... strLists) {
		Object[] array = strLists; // List<String>... => List[], 배열은 공변
		List<Integer> tmpList = List.of(42);
		array[0] = tmpList; // Object 배열에 숫자가 담긴 리스트를 넣었는데
		String s = strLists[0].get(0); // String으로 캐스팅 되지 않는다. 오류!
	}
	
	@SafeVarargs
	static <T> void safe(T... values) {
		for (T value : values) {
			System.out.println(value);
		}
	}
	
	public static void main(String[] args) {
		Fruit.safe("a", "b", "c");
		Fruit.notSafe(List.of("a", "b", "c"));
	}

}
