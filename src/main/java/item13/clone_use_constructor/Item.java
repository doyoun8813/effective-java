package item13.clone_use_constructor;

public class Item implements Cloneable {

	private String name;

	// 제대로 구현된 clone 메서드 Object의 clone메서드를 부른다.
	// Item 클래스를 반환하지만 서브 클래스에서 메서드 사용시 불러온 클래스 타입을 리턴한다.
	@Override
	protected Item clone() {
		try {
			return (Item) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

}
