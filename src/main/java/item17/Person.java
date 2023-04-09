package item17;

public class Person {
	
	private final Address address;

	public Person(Address address) {
		this.address = address;
	}
	
	public Address getAddress() {
		// 방어적 복사
		Address copyOfAddress = new Address();
		copyOfAddress.setStreet(address.getStreet());
		copyOfAddress.setZipCode(address.getZipCode());
		copyOfAddress.setCity(address.getCity());
		return copyOfAddress;
		
		//return address;
	}
	
	public static void main(String[] args) {
		Address seattle = new Address();
		seattle.setCity("Seattle");
		
		Person person = new Person(seattle);
		
		Address redmond = person.getAddress();
		redmond.setCity("Redmond");
		
		System.out.println(person.address.getCity()); // Seattle
		System.out.println(redmond.getCity()); // Redmond
	}

}
