package item26.terms;

public class UseRawType<E> {

	private E e;
	
	public static void main(String[] args) {
		System.out.println(UseRawType.class);
		
		UseRawType<String> stringType = new UseRawType<>();
		
		System.out.println(stringType instanceof UseRawType<?>);
	}

}
