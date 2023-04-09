package item21;

public class SubClass extends SuperClass implements MarkerInterface3, MarkerInterface2 {
	
	void rrr() {
		System.out.println(RRR);
	}
	

	public static void main(String[] args) {
		SubClass subClass = new SubClass();
		subClass.hello();
	}
	
}
