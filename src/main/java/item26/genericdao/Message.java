package item26.genericdao;

public class Message implements Entity  {
	
	private Long id;
	private String username;

	public Message(Long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
	@Override
	public Long getId() {
		return this.id;
	}

}
