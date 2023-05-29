package item38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

	public static void main(String[] args) {
//		test(BasicOperation.class,4,2);
//		test2(Arrays.asList(ExtendedOperation.values()),4,2);
		List<Operation> extendedOperations = Arrays.asList(ExtendedOperation.values());
		List<Operation> opSet = Arrays.asList(BasicOperation.values());
		  
		// ExtendedOperation과 BasicOperation을 합침
		List<Operation> list = new ArrayList<>();
		list.addAll(extendedOperations);
		list.addAll(opSet);
		  
		test2(list,4,2);
	}
	
	private static <T extends Enum<T> & Operation> void test(
			Class<T> opEnumType, double x, double y) {
		for (Operation op : opEnumType.getEnumConstants()) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));			
		}
	}
	
	private static void test2(Collection<? extends Operation> opSet, double x, double y) {
		for (Operation op : opSet) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}

}
