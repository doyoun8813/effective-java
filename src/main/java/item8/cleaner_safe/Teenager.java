package item8.cleaner_safe;

public class Teenager {

	public static void main(String[] args) {
		// cleaner 사용한 방청소
		new Room(99);
		System.out.println("peace out");
		// 만약 가비지 컬렉션이 안이루어 진다면? 언제 청소가 될지 모름
		System.gc();		
		
	}// end of main

}// end of class
