package item34;

public enum Planet {
	
	MERCURY(3.302e+23, 2.439e6),
	VENUS(4.869e+24, 6.052e6),
	EARTH(5.975e+24, 6.378e6),
	MARS(6.419e+23, 3.393e6),
	JUPITER(1.899e+27, 7.149e7),
	SATURN(5.685e+26, 6.027e7),
	URANUS(8.683e+25, 2.556e7),
	NEPTUNE(1.04e+26, 2.477e7);
	
	private final double mass; // 질량(킬로그램)
	private final double radius; // 반지름(미터)
	private final double surfaceGravity; // 표면중력(m / s^2)
	
	// 중력상수 (m^3 / kg s^2)
	private static final double G = 6.67300E-11;

	// 생성자
	private Planet(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
		// 최적화를 위한 단순 표면중력 계산
		surfaceGravity = G * mass / (radius * radius);
	}
	
	public double mass() { return mass; }
	public double radius() { return radius; }
	public double surfaceGravity() { return surfaceGravity; }
	
	// 대상 객체의 질량을 입력 받아, 그 객체가 행성 표면에 있을 때의 무게를 반환한다.
	public double surfaceWeight(double mass) {
		return mass * surfaceGravity; // F = ma
	}
	
	public static void main(String[] args) {
		
		double earthWeight = Double.parseDouble("185");
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		// 정의된 상수들의 값을 배열에 담아 반환하는 정적 메서드 values()
		for (Planet p : Planet.values()) {
			System.out.printf("%s에서의 무게는 %f이다. %n", p, p.surfaceWeight(mass));;
		}
	}

}
