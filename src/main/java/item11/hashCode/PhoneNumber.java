package item11.hashCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class PhoneNumber {
	
	private final short areaCode, prefix, lineNum;

	public PhoneNumber(int areaCode, int prefix, int lineNum) {
		super();
		this.areaCode = rangeCheck(areaCode, 999, "area code");
		this.prefix = rangeCheck(prefix, 999, "prefix");
		this.lineNum = rangeCheck(lineNum, 999, "line num");
	}
	
	private static short rangeCheck(int val, int max, String arg) {
		if (val < 0 || val > max) {
			throw new IllegalArgumentException(arg + " : " + val);
		}
		
		return (short) val;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		
		if (!(obj instanceof PhoneNumber)) return false;
		
		PhoneNumber pn = (PhoneNumber) obj;
		return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
	}
	
	
//	@Override
//	public int hashCode() {
//		return 42;
//	}
	
	
	// �������� hashCode �޼���
	@Override
	public int hashCode() {
		// field ���� primitive type �̸� wrapper Ŭ������ hashCode �޼��� ���
		int result = Short.hashCode(areaCode);
		result = 31 * result + Short.hashCode(prefix);
		result = 31 * result + Short.hashCode(lineNum);
		return result;
	}
	
	// �� ��¥�� hashCode �޼��� - ������ �ƽ���
//	@Override
//	public int hashCode() {
//		return Objects.hash(lineNum, prefix, areaCode);
//	}
//
//	// �ؽ��ڵ带 ���� �ʱ�ȭ �ϴ� �޼��� - ������ ������ ��� 
//	private int hashCode; // �ڵ����� 0 �ʱ�ȭ
//
//	@Override
//	public int hashCode() {
//		int result = hashCode;
//		if (result == 0) {
//			result = Short.hashCode(areaCode);
//			result = 31 * result + Short.hashCode(prefix);
//			result = 31 * result + Short.hashCode(lineNum);
//			hashCode = reuslt;
//		}
//		return result;
//	}
//	
//	// ĳ�ÿ� ����� �����͸� �о�� �� �ٸ� �����尡 ������Ʈ �߾ ������ ĳ���� �����Ͱ� �ҷ��� �� �ִµ�
//	// volatile Ű���带 ����ϸ� ���� �޸𸮿� �����͸� �����ؼ� ���� �ֱٿ� ������Ʈ�� �����͸� ������ �� �ִ�.
//	private volatile int hashCode;
//	
//	// ������ ������ ����� hashCode �޼���
//	// double checked locking
//	@Override
//	public int hashCode {
//		if(this.hashCode != 0) {
//			return hashCode;
//		}
//		
//		synchronized (this) {
//			int result = hashCode;
//			if (result == 0) {
//				result = Short.hashCode(areaCode);
//				result = 31 * result + Short.hashCode(prefix);
//				result = 31 * result + Short.hashCode(lineNum);
//				hashCode = reuslt;
//			}
//			return result;
//		}		
//	}
	
	
	public static void main(String[] args) {
		Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
		m.put(new PhoneNumber(707, 867, 5390), null);
		System.out.println(m.get(new PhoneNumber(707, 869, 5390)));
	}// end of main

}// end of class
