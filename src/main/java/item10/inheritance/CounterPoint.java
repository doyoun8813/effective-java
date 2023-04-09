package item10.inheritance;

import java.util.concurrent.atomic.AtomicInteger;

import item10.Point;

public class CounterPoint extends Point {

	private static final AtomicInteger counter = new AtomicInteger();
	
	public CounterPoint(int x, int y) {
		super(x, y);
		counter.incrementAndGet();
	}
	
	public static int numberCreated() {
		return counter.get();
	}
	
}
