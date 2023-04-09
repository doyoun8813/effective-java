package generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class GenericTest {
	
	public static void main(String[] args) {		
		ArrayList<Product> list = new ArrayList<Product>();
		
		list.add(new Product());
		list.add(new Tv());
		list.add(new Audio());
		//list.add(new Person()); // Product의 자손이 아닌 객체는 오류
		
		Product p = list.get(0);
		Product tv = list.get(1);
		Audio audio = (Audio) list.get(2); // 자식의 본인 타입으로 받으려면 형변환이 필요하다.
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			
			product.on();
		}
	}
}

class Product {
	void on() {
		System.out.println("전원을 켠다.");
	}
}

class Tv extends Product {
	void on() {
		System.out.println("티비를 켠다.");
	}
}

class Audio extends Product {	
	void on() {
		System.out.println("오디오를 켠다.");
	}	
}

class Person {
	void wakeUp() {
		System.out.println("나는 사람. 일어났다.");
	}
}