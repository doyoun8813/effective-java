package item36;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class Text {
	
//	public static final int STYLE_BOLD = 1 << 0;			// 0001 = 1
//	public static final int STYLE_ITALIC = 1 << 1;			// 0010 = 2
//	public static final int STYLE_UNDERLINE = 1 << 2;		// 0100 = 4
//	public static final int STYLE_STRIKETHROUGH = 1 << 3;	// 1000 = 8
	
	public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }
	
//	public void applyStyle(int styles) {
//		System.out.printf("Appliying styles %s to text%n", Objects.requireNonNull(styles));
//	}
	
	public void applyStyle(Set<Style> styles) {
		System.out.printf("Appliying styles %s to text%n", Objects.requireNonNull(styles));
	}
	
	public static void main(String[] args) {
		Text text = new Text();
//		text.applyStyle(STYLE_BOLD | STYLE_ITALIC);
		text.applyStyle(EnumSet.of(Style.BOLD, Style.ITALIC));
	}

}
