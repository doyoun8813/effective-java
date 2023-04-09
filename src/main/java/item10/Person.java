package item10;

public class Person {
	
	private String name;
	private int age;
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	
	public static void main(String[] args) {
		
		Person personA = new Person("Harry", 10);
		Person personB = new Person("Harry", 10);
		Person personC = personA;
		
		System.out.println(personA.equals(personB));
		System.out.println(personA.equals(personC));
		
	}

}
