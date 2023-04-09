package item14;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class wordList {

	
	public static void main(String[] args) {
		Set<String> s = new TreeSet<String>();
		String[] sArr = {"a","b","x","s","e","f","g","d","s"};
		Collections.addAll(s, sArr);
		System.out.println(s);
	}
	
	
}
