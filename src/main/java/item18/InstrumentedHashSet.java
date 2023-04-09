package item18;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class InstrumentedHashSet<E> extends HashSet<E> {
	
	// 추가된 원소의 수
	private int addCount = 0;
	
	public InstrumentedHashSet() {
		
	}
	
	public InstrumentedHashSet(int initCap, float leadFactor) {
		super(initCap, leadFactor);
	}
	
	// 요소를 더할 때 addCount 추가
	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	// 넘겨받은 컬렉션 요소들 총 갯수 addCount에 추가 
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
		s.addAll(List.of("틱", "탁탁", "펑"));
		System.out.println(s.getAddCount()); // 6
	} // end of main

}
