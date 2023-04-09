package Item15.class_and_interfaces.item;

import Item15.class_and_interfaces.member.MemberService;

public class ItemService {
	
	// 상수를 제외한 모든 인스턴스 필드는 되도록 public이 아니어야 한다.
	// 상수 제외
	public static final String NAME = "doyoun";
	
	private MemberService memberService;
	
	boolean onSale;
	
	protected int sasleRate;
	
	public ItemService(MemberService memberService) {
		this.memberService = memberService;
	}

	MemberService getMemberService() {
		return memberService;
	}
	
	
}
