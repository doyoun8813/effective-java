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
	
	
	// 전형적인 hashCode 메서드
	@Override
	public int hashCode() {
		// field 값이 primitive type 이면 wrapper 클래스의 hashCode 메서드 사용
		int result = Short.hashCode(areaCode);
		result = 31 * result + Short.hashCode(prefix);
		result = 31 * result + Short.hashCode(lineNum);
		return result;
	}
	
	// 한 줄짜리 hashCode 메서드 - 성능이 아쉽다
//	@Override
//	public int hashCode() {
//		return Objects.hash(lineNum, prefix, areaCode);
//	}
//
//	// 해시코드를 지연 초기화 하는 메서드 - 스레드 안정성 고려 
//	private int hashCode; // 자동으로 0 초기화
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
//	// 캐시에 저장된 데이터를 읽어올 때 다른 스레드가 업데이트 했어도 예전에 캐시한 데이터가 불려올 수 있는데
//	// volatile 키워드를 사옹하면 메인 메모리에 데이터를 저장해서 가장 최근에 업데이트된 데이터를 참조할 수 있다.
//	private volatile int hashCode;
//	
//	// 스레드 안정성 고려한 hashCode 메서드
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
