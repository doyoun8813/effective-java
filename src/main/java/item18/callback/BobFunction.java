package item18.callback;

public class BobFunction implements FunctionToCall {
	
	private final Service service;
	
	public BobFunction(Service service) {
		this.service = service;
	}

	@Override
	public void call() {
		System.out.println("π‰ ∏‘¿ª±Ó..");
	}

	@Override
	public void run() {
		this.service.run(this);
	}

}
