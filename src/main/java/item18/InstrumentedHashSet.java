package item18;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class InstrumentedHashSet<E> extends HashSet<E> {
	
	// �߰��� ������ ��
	private int addCount = 0;
	
	public InstrumentedHashSet() {
		
	}
	
	public InstrumentedHashSet(int initCap, float leadFactor) {
		super(initCap, leadFactor);
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
		InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
		s.addAll(List.of("ƽ", "ŹŹ", "��"));
		System.out.println(s.getAddCount()); // 6
	} // end of main

}
