package item34;

public class EnumPatternTest {
	
	// ���� ���� ����

	public static final int APPLE_FUJI = 0;
	public static final int APPLE_PIPPIN = 1;
	public static final int APPLE_GRANNY_SMITH = 2;

	public static final int ORANGE_NAVEL = 0;
	public static final int ORANGE_TEMPLE = 1;
	public static final int ORANGE_BLOOD = 2;
	
	public static final String MON = "Monday";
	
	public static void orangeJuice(int orange) {
		System.out.println(orange);
		System.out.println(EnumPatternTest.ORANGE_NAVEL);
		
		if(EnumPatternTest.ORANGE_NAVEL == orange) {
			System.out.println("Orange Juice");			
		}
	}
	
	public static String whatDay(String day) {
		if(day.equals("Mondat")) {
			return "������";
		}else {
			return "�ٸ�����";
		}
		
//		if(day.equals(EnumPatternTest.MON)) {
//			return "������";
//		}else {
//			return "�ٸ�����";
//		}
	}

	public static void main(String[] args) {
		
		orangeJuice(EnumPatternTest.APPLE_FUJI);
		
		
		
	}

}
