package item28;

import java.util.Vector;

public class SafeVarargsTest {
	public static final int ORANGE = 0;
	public static final int APPLE = 0;
	
	public static void orange(int orange) {
		if(SafeVarargsTest.ORANGE== orange) {
			System.out.println("orange");
		}
	}

	// 컬렉션을 사용한 가변인자 테스트 메서드
	public static void collectionArgs(Vector v) {
		for (Object obj : v) {
			System.out.println("컬렉션 가변인자 : " + obj);
		}
	}
	
	// 배열을 사용한 가변인자 테스트 메서드
	public static void arrayArgs(Object[] arr) {
		for (Object obj: arr) {
			System.out.println("배열 가변인자 : " + obj);
		}
	}
	
	// 새로운 가변인자를 사용한 기법 테스트 메서드
	public static void varArgs(String... strs) {
		for (String str : strs) {
			System.out.println("가변배열 : " + str);
		}
	}	
	
	public static void main(String[] args) {
		
		orange(SafeVarargsTest.APPLE);
		
		Vector v = new Vector();
		v.add("Hello");
		v.add("Hi");
		
		Object[] obj = new String[3];
		obj[0] = "Hello";
		obj[1] = "Bye";
		
		SafeVarargsTest.collectionArgs(v); // 컬렉션
		
		System.out.println("------------------");
		
		SafeVarargsTest.arrayArgs(obj); // 배열
		
		System.out.println("------------------");
		
		SafeVarargsTest.varArgs("Hello", "Hey"); // 가변인자
		
	}
	
}
