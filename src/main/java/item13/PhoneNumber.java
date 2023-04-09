package item13;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber implements Cloneable{
	
	private final int areaCode, prefix, lineNum;
	
	public PhoneNumber(int areaCode, int prefix, int lineNum) {
		super();
		this.areaCode = rangeCheck(areaCode, 999, "지역코드");
		this.prefix = rangeCheck(prefix, 999,"프리픽스");
		this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
	}
	
	private static int rangeCheck(int val, int max, String arg) {
		if(val < 0 || val > max) {
			throw new IllegalArgumentException(arg + " : " + val);
		}
		return val;
	}

	/**
	 * 전화번호의 문자열 형식은 "XXX-YYY-ZZZZ" 형태의 12글자
	 * XXX는 지역코드, YYY는 프리픽스, ZZZZ는 가입자 번호
	 * 각 대문자는 10진수 숫자를 나타낸다.
	 * 각 부분의 자릿수를 채울 수 없다면 앞에서부터 0으로 채운다.
	 */
	@Override
	public String toString() {
		return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
	}
	
	// PhoneNumber 클래스의 정보를 제공하는 팩터리 메서드
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

	// 메서드 overriding시 접근 제어자는 원본 메서드 보다 범위를 넓게 가질 수 있다.	
	// private, default 제어자는 protected보다 범위가 더 좁기 때문에 선언 불가
	// 외부 객체에서 사용할 수 있게 public으로 선언
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
