package Item15.class_and_interfaces.item;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import Item15.class_and_interfaces.item.ItemService;
import Item15.class_and_interfaces.member.MemberService;

class ItemServiceTest {
	
	MemberService memberService;
	
	@Test
	void itemService() {
		ItemService itemService = new ItemService(memberService);
		assertNotNull(itemService);
		assertNotNull(itemService.getMemberService());
	}

}
