package item26.terms;

import java.util.ArrayList;
import java.util.List;

public class Raw {
	
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
//		unsafeAdd(strings, Integer.valueOf(42));
		String s = strings.get(0); // �����Ϸ��� �ڵ����� ����ȯ �ڵ带 �־��ش�.
	}
	
	private static void unsafeAdd(List<Object> list, Object o) {
		list.add(o);
	}

}
