package item20.templatemethod;

public class Client {

	public static void main(String[] args) {
		FileProcessor fileProcessor	 = new Plus("src\\main\\java\\item20\\templatemethod\\number.txt");
		System.out.println(fileProcessor.process()); // 15
	}
}
