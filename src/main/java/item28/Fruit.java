package item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import item28.Fruit.FruitBox;

public class Fruit implements Eatable{	
		
	private static class Apple extends Fruit {
		public String toString() { return "Apple"; } 
	}
	
	private static class Grape extends Fruit {
		public String toString() { return "Grape"; }
	}
	
	public static class Toy {
		public String toString() { return "Toy"; }
	}
	
	public static class FruitBox<T extends Fruit> extends Box<T> {
		
		
		static <T> void sort(List<T> list, Comparator<? super T> c) {
			
		}
		

		public List<Fruit> getList() {
			List<Fruit> list = new ArrayList<Fruit>();
			// TODO Auto-generated method stub
			return list;
		}
	}
	
	public static class Box<T> {
		ArrayList<T> list = new ArrayList<T>();
		void add(T item) { list.add(item); }
		T get(int i) { return list.get(i); }
		int size() { return list.size(); }
		List getList() { return list; }
		public String toString() { return list.toString(); }
	}
	
	public String toString() { return "Fruit"; }
	
	
		
	public static void main(String[] args) {		
		FruitBox<Fruit> fruitBox = new FruitBox<>();
		FruitBox<Apple> appleBox = new FruitBox<>();
		FruitBox<Grape> grapeBox = new FruitBox<>();
		//FruitBox<Grape> grapeBox2 = new FruitBox<Apple>(); // 에러 타입 불일치
		//FruitBox<Toy> toyBox = new FruitBox<>(); // 에러 Toy는 Fruit의 자손이 아님
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		//toyBox.add(new Toy());
		appleBox.add(new Apple());
		//appleBox.add(new Grape()); // 에러 Grape는 Apple의 자손이 아님
		grapeBox.add(new Grape());
		
		System.out.println("fruitBox-"+fruitBox);
		System.out.println("appleBox-"+appleBox);
		System.out.println("grapeBox-"+grapeBox);
		
		
		ArrayList<Apple> list = new ArrayList<Apple>(); // OK. 제네릭 타입 일치
		List<Apple> list2 = new ArrayList<Apple>(); // OK. 다형성. 제네릭 타입 일치
		
		ArrayList<Fruit> list3 = new ArrayList<Apple>();
		
		// 제네릭 타입이 '? extends Fruit'이면, Fruit와 Fruit의 모든 자손 OK
		ArrayList<? extends Fruit> list4 = new ArrayList<Apple>();
		ArrayList<? extends Fruit> list5 = new ArrayList<Grape>();
		
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
		
	}
}

interface Eatable {}

class Juicer {
	
	static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
		String tmp = "";
		for (Fruit f : box.getList()) 
			tmp += f + " ";
		return new Juice(tmp);
	}
	
}

class Juice {
	String name;
	Juice(String name) { this.name = name + "Juice"; }
}