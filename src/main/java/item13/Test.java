package item13;

public class Test extends Parent{
	
	public static Parent parent;
	
	public Test() {
		try {
			
			Object obj = super.clone();
			parent = (Parent) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Parent parent = new Parent();
		Child child = new Child();
		
		parent.createNewOne();
		child.createNewOne();
		
	}
	
}

class Parent implements Cloneable{
	
	protected Parent createNewOne() throws CloneNotSupportedException {
		Parent parent = new Parent();
		
		// 명시적 형변환. 타입 캐스팅
		Parent obj = (Parent) parent.clone();
		
		System.out.println(parent);
		System.out.println(obj);
		
		System.out.println(parent != obj);
		System.out.println(parent.getClass() == obj.getClass());
		System.out.println(parent.equals(obj));
		
		return new Parent();
	}
}

class Child extends Parent {
	@Override
	public Child createNewOne() throws CloneNotSupportedException {
		Child child = new Child();
		
		Object obj = child.clone();
		
		System.out.println(child);
		System.out.println(obj);
		
		
		return new Child();
	}
}
