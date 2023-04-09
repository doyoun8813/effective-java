package Item15.class_and_interfaces.member;

import java.util.Arrays;

class DefaultMemberService implements MemberService {
	
	private String name;
	
	// static이 붙었을 땐 톱레벨 클래스와 연관 관계가 없다.
	// DefaultMemberService 클래스에 관련된 사항을 사용할 수없다.
	// 애초에 독립적인 객체를 DefaultMemberService에만 쓰려고 데려온 애라서
	private static interface MemberRepository {
		
		void doPrint();
		
	}
	
	// 톱레벨 클래스인 DefaultMemberService 인스턴스를 참조하고 있다.
	private class PrivateClass {
		
		void doPrint() {
			System.out.println(name);
		}
		
	}
	
	public static void main(String[] args) {
		Arrays.stream(PrivateClass.class.getDeclaredFields()).forEach(System.out::println);
	}

}
