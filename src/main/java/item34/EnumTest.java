package item34;

public class EnumTest {

	public enum Apple { NAVEL, TEMPLE, BLOOD }
	public enum Orange { NAVEL, TEMPLE, BLOOD }
	
	public static void orangeJuice(Orange orange) {
		System.out.println(orange);
		System.out.println(EnumPatternTest.ORANGE_NAVEL);
		
		if(Orange.NAVEL == orange) {
			System.out.println("Orange Navel Juice");			
		}
	}
	
	public static void main(String[] args) {
//		orangeJuice(Apple.FUJI);
	}

}
