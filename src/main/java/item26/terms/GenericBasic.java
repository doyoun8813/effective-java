package item26.terms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericBasic {
	
	public static void main(String[] args) {
		//Generic 사용 전
//		List numbers = new ArrayList();
//		numbers.add(10);
//		numbers.add("whiteship");
//		
//		for (Object number : numbers) {
//			System.out.println((Integer) number);
//		}	
		
		//Generic 사용 후
		List<Integer> numbers = new ArrayList<>();
		numbers.add(10);
		numbers.add("whiteship");
		
		for (Integer number : numbers) {
			System.out.println(number);
		}
		
	}
	
}
