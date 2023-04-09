package item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Wrapper Ŭ����
public class InstrumentedSet<E> extends ForwardingSet<E> {
	
	// �߰��� ������ ��
	private int addCount = 0;

	public InstrumentedSet(Set<E> s) {
		super(s);
	}

	// ��Ҹ� ���� �� addCount �߰�
	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	// �Ѱܹ��� �÷��� ��ҵ� �� ���� addCount�� �߰�
	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}
	
	public int getAddCount() {
		return addCount;
	}

	public static void main(String[] args) {
		InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
		s.addAll(List.of("ƽ", "ŹŹ", "��"));
		System.out.println(s.getAddCount()); // 3
	}// end of main

}
