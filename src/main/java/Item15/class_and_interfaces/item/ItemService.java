package Item15.class_and_interfaces.item;

import Item15.class_and_interfaces.member.MemberService;

public class ItemService {
	
	// ����� ������ ��� �ν��Ͻ� �ʵ�� �ǵ��� public�� �ƴϾ�� �Ѵ�.
	// ��� ����
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
