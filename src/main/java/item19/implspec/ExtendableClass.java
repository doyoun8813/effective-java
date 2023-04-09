package item19.implspec;

/**
 * 
 * @author Doyoun
 * Example class for java documentation for extendable class
 *
 */
public class ExtendableClass {
	
	/**
	 * This method can be override to print any message.
	 * 
	 * @implSpec
	 * Please use System.out.println().
	 */
	public void doSomethis() {
		System.out.println("hello");
	}

}
