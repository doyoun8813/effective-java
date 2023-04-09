package item13.clone_use_constructor;

public class SubItem extends Item implements Cloneable {
	
	private String name;
	
	// 일반적인 규약을 따른 clone 메서드
	@Override
	public SubItem clone() {
		return (SubItem) super.clone();
	}

	public static void main(String[] args) {
		SubItem item = new SubItem();
		SubItem clone = item.clone();
		System.out.println(clone != item); // true
		System.out.println(clone.getClass() == item.getClass()); // true
		System.out.println(clone.equals(item)); // false
	}

}
