package item34;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation5 {

	
	    PLUS("+") {
	        public double apply(double x, double y) { return x + y; }
	    },
	    MINUS("-") {
	        public double apply(double x, double y) { return x - y; }
	    },
	    TIMES("*") {
	        public double apply(double x, double y) { return x * y; }
	    },
	    DIVIDE("/") {
	        public double apply(double x, double y) { return x / y; }
	    };

	    private final String symbol;

	    Operation5(String symbol) {
	    	this.symbol = symbol;
//	    	System.out.println(a.get(symbol));
	    	}
	    

	    @Override public String toString() { return symbol; }

	    public abstract double apply(double x, double y);
	    
	    private static final Map<String, Operation5> stringToEnum =
				Stream.of(values()).collect(Collectors.toMap(Object::toString, e -> e));
		

	    private static final Map<String, String> a = new HashMap<String, String>();	
	    
	    
	    // ������ ���ڿ��� �ش��ϴ� Operation�� (�����Ѵٸ�) ��ȯ�Ѵ�.
	    public static Optional<Operation5> fromString(String symbol) {
	    	System.out.println("!!!!!!!!!!!!!!!!!!!!");
	        return Optional.ofNullable(stringToEnum.get(symbol));
	    }

	    public static void main(String[] args) {
	        double x = Double.parseDouble("1.2");
	        double y = Double.parseDouble("5.0");
	        for (Operation op : Operation.values())
	            System.out.printf("%f %s %f = %f%n",
	                    x, op, y, op.apply(x, y));
//	        System.out.println(Operation5.fromString(Operation5.PLUS));
	  
	    }
	

}
