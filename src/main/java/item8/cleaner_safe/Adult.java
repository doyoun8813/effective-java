package item8.cleaner_safe;

public class Adult {

	public static void main(String[] args) {
		// try with resources 规过栏肺 规没家
		try(Room myRoom = new Room(7)){
			System.out.println("救崇~");
		}
	}// end of main

}// end of class
