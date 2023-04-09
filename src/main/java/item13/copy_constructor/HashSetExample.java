package item13.copy_constructor;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetExample {

	public static void main(String[] args) {

		Set<String> hashSet = new HashSet<>();
		hashSet.add("doyoun");
		hashSet.add("whiteship");
		System.out.println("HashSet : " + hashSet);
		
		// Collection�� �޴� �����ڷ� copy
		Set<String> treeSet = new TreeSet<>(hashSet);
		
		System.out.println("TreeSet : " + treeSet);
		
	}

}
