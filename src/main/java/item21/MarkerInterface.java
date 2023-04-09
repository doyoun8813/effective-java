package item21;

public interface MarkerInterface {
	
	//String RRR = "hi";

	default void hello() {
		System.out.println("hello Interface");
	}
	
	static void hi() {
		System.out.println("hi");
	}
}
