package item26.terms;

import java.util.concurrent.atomic.AtomicInteger;

public class Box<E> {

	private E item;
	
	private void add(E e) {
		this.item = e;
	}
	
	private E get() {
		return this.item;
	}
	
	public static void main(String[] args) {
		Box<? extends Number> box = new Box<>();
		box.add(10);
		printBox(box);
	}
	
	private static void printBox(Box<?> box) {
		System.out.println(box.get());
	}

}
