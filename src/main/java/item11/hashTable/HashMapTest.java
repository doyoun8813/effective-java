package item11.hashTable;

import java.util.HashMap;
import java.util.Map;

import item11.hashCode.PhoneNumber;

public class HashMapTest {

	public static void main(String[] args) {
		Map<PhoneNumber, String> map = new HashMap<PhoneNumber, String>();
		PhoneNumber number1 = new PhoneNumber(123, 456, 789);
		//PhoneNumber number2 = new PhoneNumber(123, 456, 789);
		PhoneNumber number2 = new PhoneNumber(456, 789, 012);
		
		System.out.println(number1.equals(number2)); // false
		System.out.println(number1.hashCode()); // 42
		System.out.println(number2.hashCode()); // 42
		
		map.put(number1, "doyoun");
		map.put(number2, "effective java");
		
		String s = map.get(number1); 
		String s1 = map.get(new PhoneNumber(123,456,789));
		System.out.println(s); // doyoun
		System.out.println(s1); // doyoun
	}

}
