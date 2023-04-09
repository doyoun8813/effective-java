package item13.clone_use_constructor;

public class Item implements Cloneable {

	private String name;

	// ����� ������ clone �޼��� Object�� clone�޼��带 �θ���.
	// Item Ŭ������ ��ȯ������ ���� Ŭ�������� �޼��� ���� �ҷ��� Ŭ���� Ÿ���� �����Ѵ�.
	@Override
	protected Item clone() {
		try {
			return (Item) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

}
