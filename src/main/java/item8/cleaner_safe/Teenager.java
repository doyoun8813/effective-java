package item8.cleaner_safe;

public class Teenager {

	public static void main(String[] args) {
		// cleaner ����� ��û��
		new Room(99);
		System.out.println("peace out");
		// ���� ������ �÷����� ���̷�� ���ٸ�? ���� û�Ұ� ���� ��
		System.gc();		
		
	}// end of main

}// end of class
