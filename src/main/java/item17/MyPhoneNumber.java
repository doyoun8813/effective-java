package item17;

import item12.PhoneNumber;

public class MyPhoneNumber extends PhoneNumber {

	public MyPhoneNumber(int areaCode, int prefix, int lineNum) {
		super(areaCode, prefix, lineNum);
		// TODO Auto-generated constructor stub
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
