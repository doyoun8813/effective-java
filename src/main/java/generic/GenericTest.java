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
		//list.add(new Person()); // Product�� �ڼ��� �ƴ� ��ü�� ����
		
		Product p = list.get(0);
		Product tv = list.get(1);
		Audio audio = (Audio) list.get(2); // �ڽ��� ���� Ÿ������ �������� ����ȯ�� �ʿ��ϴ�.
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			
			product.on();
		}
	}
}

class Product {
	void on() {
		System.out.println("������ �Ҵ�.");
	}
}

class Tv extends Product {
	void on() {
		System.out.println("Ƽ�� �Ҵ�.");
	}
}

class Audio extends Product {	
	void on() {
		System.out.println("������� �Ҵ�.");
	}	
}

class Person {
	void wakeUp() {
		System.out.println("���� ���. �Ͼ��.");
	}
}