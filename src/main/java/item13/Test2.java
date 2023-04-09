package item13;

import java.util.AbstractMap;

public class Test2 {
	
    public static void main(String[] args) {
        Parent2 parent = new Parent2();
        Child2 child = new Child2();
        Parent2 pc = new Child2();

        System.out.println(parent.createNewOne().getClass());
        System.out.println(child.createNewOne().getClass());
        System.out.println(pc.createNewOne().getClass());
  
        
    }
	

}

class Parent2 {
	public void hello() {
		System.out.println("hello");
	}
	
    protected Parent2 createNewOne() {
        return new Parent2();
    }
}

class Child2 extends Parent2 {
    // 부모 클래스로부터 재정의하였으나 반환형을 자식 클래스로 변경할 수 있다.
    @Override public Child2 createNewOne() {
        return new Child2();
    }
}