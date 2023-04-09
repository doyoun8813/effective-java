package item16.dimension;

import java.awt.Button;
import java.awt.Dimension;

public class DimensionExample {

	public static void main(String[] args) {
		Button button = new Button("Hello Button");
		button.setBounds(0, 0, 20, 10);
		
		// 패키지 밖에서 Demension 필드로 접근하여 값을 사옹하면
		// 언제 어디서 변경될지 알 수 없으니
		// 다른 곳에서 안전하게 사용하려면 사용하는 곳에서 Demension을 복사하여
		// 별도의 참조값을 가지며 사용해야 한다.
		// 이렇게 복사를 하게되는 일이 여러번 이루어지면 성능도 좋을리 없다.
		Dimension size = button.getSize();
		System.out.println(size.height);
		System.out.println(size.width);
		
		doSomething(size);
	}
	
	private static void doSomething(Dimension dimension) {
		// 이렇게 값을 변경할 수 있는데 위에 초기값으로 세팅된 값과 다르다면
		// 개발자의 의도와 다르게 동작할 수 있다.
		// dimension.width = 10;
		
		// 안전하게 복사하여 사용 다행히 primitive 값이라 안전 복사 됨
		
		
		Dimension dimension2 = new Dimension();
		dimension2.height = dimension.height;
		dimension2.width = dimension.width;
		
	}
}
