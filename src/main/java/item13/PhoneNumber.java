package item13;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber implements Cloneable{
	
	private final int areaCode, prefix, lineNum;
	
	public PhoneNumber(int areaCode, int prefix, int lineNum) {
		super();
		this.areaCode = rangeCheck(areaCode, 999, "�����ڵ�");
		this.prefix = rangeCheck(prefix, 999,"�����Ƚ�");
		this.lineNum = rangeCheck(lineNum, 9999, "������ ��ȣ");
	}
	
	private static int rangeCheck(int val, int max, String arg) {
		if(val < 0 || val > max) {
			throw new IllegalArgumentException(arg + " : " + val);
		}
		return val;
	}

	/**
	 * ��ȭ��ȣ�� ���ڿ� ������ "XXX-YYY-ZZZZ" ������ 12����
	 * XXX�� �����ڵ�, YYY�� �����Ƚ�, ZZZZ�� ������ ��ȣ
	 * �� �빮�ڴ� 10���� ���ڸ� ��Ÿ����.
	 * �� �κ��� �ڸ����� ä�� �� ���ٸ� �տ������� 0���� ä���.
	 */
	@Override
	public String toString() {
		return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
	}
	
	// PhoneNumber Ŭ������ ������ �����ϴ� ���͸� �޼���
	public static PhoneNumber of(String phoneNumberString) {
		String[] split = phoneNumberString.split("-");
		PhoneNumber pn = new PhoneNumber(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
		
		return pn;				
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		
		if(!(obj instanceof PhoneNumber)) return false;
		
		PhoneNumber pn = (PhoneNumber) obj;
		return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
	}

	@Override
	public int hashCode() {
		int result = Integer.hashCode(areaCode);
		result = 31 * result + Integer.hashCode(prefix);
		result = 31 * result + Integer.hashCode(lineNum);
		return result;
	}

	// �޼��� overriding�� ���� �����ڴ� ���� �޼��� ���� ������ �а� ���� �� �ִ�.	
	// private, default �����ڴ� protected���� ������ �� ���� ������ ���� �Ұ�
	// �ܺ� ��ü���� ����� �� �ְ� public���� ����
	@Override
	public PhoneNumber clone() {
		try {
			return (PhoneNumber) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	public static void main(String[] args) {
		PhoneNumber jenny = new PhoneNumber(707, 789, 1304);
		Map<PhoneNumber, String> m = new HashMap<>();
		
		m.put(jenny, "jenny");
		PhoneNumber clone = jenny.clone();
		System.out.println(m.get(clone)); // jenny
		
		System.out.println(clone != jenny); // true
		System.out.println(clone.getClass() == jenny.getClass()); // true
		System.out.println(clone.equals(jenny)); // true
		
		
	} // end of main
	
}// end of class
