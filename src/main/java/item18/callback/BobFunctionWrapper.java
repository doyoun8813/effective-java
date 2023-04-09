package item18.callback;

public class BobFunctionWrapper implements FunctionToCall {
	
	private final BobFunction bobFunction;
	
	public BobFunctionWrapper(BobFunction bobFunction) {
		this.bobFunction = bobFunction;
	}

	@Override
	public void call() {
		this.bobFunction.call();
		System.out.println("Ŀ�ǵ� ���Ǳ�..");
	}

	@Override
	public void run() {
		this.bobFunction.run();
	}

}
