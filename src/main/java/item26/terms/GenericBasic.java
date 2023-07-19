package item26.terms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericBasic {
	
	public static void main(String[] args) {
		//Generic ��� ��
//		List numbers = new ArrayList();
//		numbers.add(10);
//		numbers.add("whiteship");
//		
//		for (Object number : numbers) {
//			System.out.println((Integer) number);
//		}	
		
		//Generic ��� ��
		List<Integer> numbers = new ArrayList<>();
		numbers.add(10);
//		numbers.add("whiteship");
		
		for (Integer number : numbers) {
			System.out.println(number);
		}
		
	}
	
}
