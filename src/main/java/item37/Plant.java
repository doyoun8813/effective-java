package item37;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Plant {
	
	enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }
	
	final String name;
	final LifeCycle lifeCycle;
	
	public Plant(String name, LifeCycle lifeCycle) {
		super();
		this.name = name;
		this.lifeCycle = lifeCycle;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static void usingOrdinalArray(List<Plant> garden) {
		@SuppressWarnings("unchecked")
		Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
		for (int i = 0; i < plantsByLifeCycle.length; i++) {
			plantsByLifeCycle[i] = new HashSet<>();
		}
		
		for (Plant p : garden) {
			plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
		}
		
		for (int i = 0; i < plantsByLifeCycle.length; i++) {
			System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
		}
	}
	
	public static void usingEnumMap(List<Plant> garden) {
		Map<LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(LifeCycle.class);
		
		for (LifeCycle lifeCycle : LifeCycle.values()) {
			plantsByLifeCycle.put(lifeCycle, new HashSet<>());
		}
		
		for (Plant plant : garden) {
			plantsByLifeCycle.get(plant.lifeCycle).add(plant);
		}
		
		System.out.println(plantsByLifeCycle);
	}
	
	public static void streamV1(List<Plant> garden) {
		System.out.println(garden.stream()
				.collect(Collectors.groupingBy(p -> p.lifeCycle)));
	}
	
	public static void streamV2(List<Plant> garden)	{
		System.out.println(garden.stream()
				.collect(Collectors.groupingBy(p -> p.lifeCycle, 
						() -> new EnumMap<>(LifeCycle.class), Collectors.toSet())));
	}
	
	public static void main(String[] args) {
		Plant corn = new Plant("옥수수", LifeCycle.ANNUAL);
		Plant pea = new Plant("완두", LifeCycle.ANNUAL);
		Plant potato = new Plant("감자", LifeCycle.PERENNIAL);
		Plant banana = new Plant("바나나", LifeCycle.BIENNIAL);
		
		List<Plant> garden = Arrays.asList(corn, potato, pea, banana);
		usingOrdinalArray(garden);
		usingEnumMap(garden);
		streamV1(garden);
		streamV2(garden);
	}

}
