package item8.cleaner_safe;

public class Adult {

	public static void main(String[] args) {
		// try with resources ������� ��û��
		try(Room myRoom = new Room(7)){
			System.out.println("�ȳ�~");
		}
	}// end of main

}// end of class
