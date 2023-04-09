package item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CaseInsensitiveString {
	
	private final String s;
	
	public CaseInsensitiveString(String s) { 
		this.s = Objects.requireNonNull(s);	
	}

	// 대칭성 위배되는 equals
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof CaseInsensitiveString)
//			// CaseInsensitiveString 객체일 경우 해당 문자열의 대소문자를 무시하고 문자열이 동일할 경우 true 리턴
//			return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
//		if(obj instanceof String) 
//			// String 객체일 경우 해당 문자열의 대소문자를 무시하고 문자열이 동일할 경우 true 리턴
//			return s.equalsIgnoreCase((String) obj);
//		
//		return false;
//	}
	
	// 수정한 equals 메서드
	@Override
	public boolean equals(Object obj) {
		return obj instanceof CaseInsensitiveString && 
				((CaseInsensitiveString) obj).s.equalsIgnoreCase(s);
	}

	public static void main(String[] args) {
		
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
		String polish = "polish";
		
		// 대칭성을 이루려면 같은 결과값이 나와야 하지만 
		// String 클래스의 equals는 대소문자 구별을 해서 다른 결과값이 나온다.
		System.out.println(cis.equals(polish));
		System.out.println(polish.equals(cis));
		
		List<CaseInsensitiveString> list = new ArrayList<>();
		list.add(cis);
		
		System.out.println("---------");
		
		System.out.println(list.contains(cis));
		System.out.println(list.contains(polish));

	}//end of main
	
}//end of class
