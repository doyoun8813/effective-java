package item34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation3 {

	PLUS("+") { public double apply(double x, double y) { return x + y; }},
	MINUS("-") { public double apply(double x, double y) { return x - y; }},
	TIMES("*") { public double apply(double x, double y) { return x * y; }},
	DIVIDE("/") { public double apply(double x, double y) { return x / y; }};
	
	private final String symbol;
	
	Operation3(String symbol) {
		this.symbol = symbol;
	}
	
	// toString을 재정의해 해당 연산을 뜻하는 기호를 반환
	@Override
	public String toString() { return symbol; }
	public abstract double apply(double x, double y);
	
	private static final Map<String, Operation3> stringToEnum =
			Stream.of(values()).collect(Collectors.toMap(Object::toString, e -> e));
	
	public static Optional<Operation3> fromString(String symbol){
		return Optional.ofNullable(stringToEnum.get(symbol));
	}
	
	public static Operation3 inverse(Operation3 op) {
		switch(op) {
		case PLUS: return Operation3.MINUS;
		case MINUS: return Operation3.PLUS;
		case TIMES: return Operation3.DIVIDE;
		case DIVIDE: return Operation3.TIMES;
		
		default: throw new AssertionError("알 수 없는 연산 : " + op);
		}
	}
	
	public static void main(String[] args) {
		double x = Double.parseDouble("2");
		double y = Double.parseDouble("5");
		for (Operation3 op : Operation3.values()) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));		
			
		}
		System.out.println(Operation3.fromString("+"));
	}
	
}
