package item26.terms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Numbers {
	
	static int numElementsInCommon(Set s1, Set s2) {
		int result = 0;
		for (Object object : s1) {
			if(s2.contains(object)) {
				result++;
			}
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<>();  
		
		ArrayList<?> mySet = set;
//		mySet.add(10);
		
		System.out.println(Numbers.numElementsInCommon(Set.of(1,2,3), Set.of(1,2)));
	}

}
