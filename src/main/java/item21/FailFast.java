package item21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFast {

	public static void main(String[] args) {
		
		// ������ �� ���� ImmutableCollection
//		List<Integer> numbers = List.of(1,2,3,4,5);
		
		// ���� ������ Collection
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
		// ���ͷ����ͷ� �ݷ����� ��ȸ�ϴ� �߿� Collection�� remove�� ����ϸ�..
//		for (Integer number : numbers) {
//			if(number == 3) {
//				numbers.remove(number);
//			}
//		}
		
		// ���ͷ������� remove ���
//		for (Iterator iterator = numbers.iterator(); iterator.hasNext();) {
//			Integer integer = (Integer) iterator.next();
//			if(integer == 3) {
//				System.out.println(integer);
//				iterator.remove();
//			}
//		}
		
		// �ε��� ���
//		for (int i = 0; i < numbers.size(); i++) {
//			if(numbers.get(i) == 3) {
//				numbers.remove(numbers.get(i));
//			}
//			
//		}
		
		// removeIf ���
		numbers.removeIf(number -> number == 3);
		
		numbers.forEach(System.out::println);
	}
}
