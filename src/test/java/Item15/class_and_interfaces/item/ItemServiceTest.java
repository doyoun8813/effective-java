package Item15.class_and_interfaces.item;

import Item15.class_and_interfaces.member.MemberService;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

class ItemServiceTest {
	
	MemberService memberService;
	
	@Test
	void itemService() {
		ItemService itemService = new ItemService(memberService);
		assertNotNull(itemService);
		assertNotNull(itemService.getMemberService());
	}

}
