package item28;

import java.util.Vector;

public class SafeVarargsTest {

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
