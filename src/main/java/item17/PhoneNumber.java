package item17;

public final class PhoneNumber {

	public final short areaCode, prefix, lineNum;
	
	private PhoneNumber(short areaCode, short prefix, short lineNum) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNum = lineNum;				
	}

	public short getAreaCode() {
		return areaCode;
	}

	public short getPrefix() {
		return prefix;
	}

	public short getLineNum() {
		return lineNum;
	}
	
}
