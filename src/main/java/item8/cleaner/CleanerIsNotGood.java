package item8.cleaner;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class CleanerIsNotGood {

	public static void main(String[] args) throws InterruptedException {

		// Cleaner ����
		Cleaner cleaner = Cleaner.create();
		
		// ����� ��ü ����
		List<Object> resourceToCleanUp = new ArrayList<Object>();
		BigObject bigObject = new BigObject(resourceToCleanUp);
		
		// Cleaner�� ��� (Cleaner gc ��� ��ü, �ڿ� ���� ��� Task)
		cleaner.register(bigObject, new BigObject.ResourceCleaner(resourceToCleanUp));
		
		bigObject = null;
		System.gc();
		Thread.sleep(3000L);
		
	}// end of main

}// end of class
