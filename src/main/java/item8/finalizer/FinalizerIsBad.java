package item8.finalizer;

public class FinalizerIsBad {

	// Object 클래스에 정의된 메서드 자바 9버전부터 Deprecated
	// 해당 클래스가 가비지컬렉션 대상이 되면 회수하기 직전 메서드가 실행되어 
	// 리소스를 해제하거나 다른 정리작업을 수행할 수 있게 만든 메서드
	// JVM에 강하거나 약한 참조가 되지 않을 때 수집대상이 된다.
	@Override
	protected void finalize() throws Throwable {
		System.out.print("");
	}	
	
}
