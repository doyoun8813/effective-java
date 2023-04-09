package Item15.class_and_interfaces.member;

import java.util.Arrays;

class DefaultMemberService implements MemberService {
	
	private String name;
	
	// static�� �پ��� �� �鷹�� Ŭ������ ���� ���谡 ����.
	// DefaultMemberService Ŭ������ ���õ� ������ ����� ������.
	// ���ʿ� �������� ��ü�� DefaultMemberService���� ������ ������ �ֶ�
	private static interface MemberRepository {
		
		void doPrint();
		
	}
	
	// �鷹�� Ŭ������ DefaultMemberService �ν��Ͻ��� �����ϰ� �ִ�.
	private class PrivateClass {
		
		void doPrint() {
			System.out.println(name);
		}
		
	}
	
	public static void main(String[] args) {
		Arrays.stream(PrivateClass.class.getDeclaredFields()).forEach(System.out::println);
	}

}
