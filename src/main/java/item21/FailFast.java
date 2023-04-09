package item21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFast {

	public static void main(String[] args) {
		
		// 수정할 수 없는 ImmutableCollection
//		List<Integer> numbers = List.of(1,2,3,4,5);
		
		// 수정 가능한 Collection
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
		// 이터레이터로 콜렉션을 순회하는 중에 Collection의 remove를 사용하면..
//		for (Integer number : numbers) {
//			if(number == 3) {
//				numbers.remove(number);
//			}
//		}
		
		// 이터레이터의 remove 사용
//		for (Iterator iterator = numbers.iterator(); iterator.hasNext();) {
//			Integer integer = (Integer) iterator.next();
//			if(integer == 3) {
//				System.out.println(integer);
//				iterator.remove();
//			}
//		}
		
		// 인덱스 사용
//		for (int i = 0; i < numbers.size(); i++) {
//			if(numbers.get(i) == 3) {
//				numbers.remove(numbers.get(i));
//			}
//			
//		}
		
		// removeIf 사용
		numbers.removeIf(number -> number == 3);
		
		numbers.forEach(System.out::println);
	}
}
