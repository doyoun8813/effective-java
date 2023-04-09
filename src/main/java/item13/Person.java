package item13;

class Person{
	String name;
	int age;
	
	public Person() {
		this("�̸����� ", 1);
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void showPersononInfo() {
		System.out.println(name+","+age);
	}
	
	public Person getSelf() {
		return this;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p1 = new Person();
		p1.showPersononInfo(); // �̸�����, 1 
		
		Person p2 = new Person("�̸��� ", 10 );
		p2.showPersononInfo(); // �̸���, 10  
		
		System.out.println(p2.getSelf());

	}
}