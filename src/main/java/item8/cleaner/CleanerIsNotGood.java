package item8.cleaner;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class CleanerIsNotGood {

	public static void main(String[] args) throws InterruptedException {

		// Cleaner 생성
		Cleaner cleaner = Cleaner.create();
		
		// 사용할 객체 생성
		List<Object> resourceToCleanUp = new ArrayList<Object>();
		BigObject bigObject = new BigObject(resourceToCleanUp);
		
		// Cleaner에 등록 (Cleaner gc 대상 객체, 자원 해제 기능 Task)
		cleaner.register(bigObject, new BigObject.ResourceCleaner(resourceToCleanUp));
		
		bigObject = null;
		System.gc();
		Thread.sleep(3000L);
		
	}// end of main

}// end of class
