package item18.callback;

public class Service {

	public void run(FunctionToCall functionToCall) {
		System.out.println("�� �� �ϴٰ�...");
		functionToCall.call();
	}

	public static void main(String[] args) {
		Service service = new Service();
		BobFunctionWrapper bobFunction = new BobFunctionWrapper(new BobFunction(service));
		bobFunction.run();
	}
}
