package item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CaseInsensitiveString {
	
	private final String s;
	
	public CaseInsensitiveString(String s) { 
		this.s = Objects.requireNonNull(s);	
	}

	// ��Ī�� ����Ǵ� equals
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof CaseInsensitiveString)
//			// CaseInsensitiveString ��ü�� ��� �ش� ���ڿ��� ��ҹ��ڸ� �����ϰ� ���ڿ��� ������ ��� true ����
//			return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
//		if(obj instanceof String) 
//			// String ��ü�� ��� �ش� ���ڿ��� ��ҹ��ڸ� �����ϰ� ���ڿ��� ������ ��� true ����
//			return s.equalsIgnoreCase((String) obj);
//		
//		return false;
//	}
	
	// ������ equals �޼���
	@Override
	public boolean equals(Object obj) {
		return obj instanceof CaseInsensitiveString && 
				((CaseInsensitiveString) obj).s.equalsIgnoreCase(s);
	}

	public static void main(String[] args) {
		
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
		String polish = "polish";
		
		// ��Ī���� �̷���� ���� ������� ���;� ������ 
		// String Ŭ������ equals�� ��ҹ��� ������ �ؼ� �ٸ� ������� ���´�.
		System.out.println(cis.equals(polish));
		System.out.println(polish.equals(cis));
		
		List<CaseInsensitiveString> list = new ArrayList<>();
		list.add(cis);
		
		System.out.println("---------");
		
		System.out.println(list.contains(cis));
		System.out.println(list.contains(polish));

	}//end of main
	
}//end of class
