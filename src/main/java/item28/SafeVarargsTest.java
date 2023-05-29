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

	// �÷����� ����� �������� �׽�Ʈ �޼���
	public static void collectionArgs(Vector v) {
		for (Object obj : v) {
			System.out.println("�÷��� �������� : " + obj);
		}
	}
	
	// �迭�� ����� �������� �׽�Ʈ �޼���
	public static void arrayArgs(Object[] arr) {
		for (Object obj: arr) {
			System.out.println("�迭 �������� : " + obj);
		}
	}
	
	// ���ο� �������ڸ� ����� ��� �׽�Ʈ �޼���
	public static void varArgs(String... strs) {
		for (String str : strs) {
			System.out.println("�����迭 : " + str);
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
		
		SafeVarargsTest.collectionArgs(v); // �÷���
		
		System.out.println("------------------");
		
		SafeVarargsTest.arrayArgs(obj); // �迭
		
		System.out.println("------------------");
		
		SafeVarargsTest.varArgs("Hello", "Hey"); // ��������
		
	}
	
}
