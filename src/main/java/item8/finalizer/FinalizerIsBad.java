package item8.finalizer;

public class FinalizerIsBad {

	// Object Ŭ������ ���ǵ� �޼��� �ڹ� 9�������� Deprecated
	// �ش� Ŭ������ �������÷��� ����� �Ǹ� ȸ���ϱ� ���� �޼��尡 ����Ǿ� 
	// ���ҽ��� �����ϰų� �ٸ� �����۾��� ������ �� �ְ� ���� �޼���
	// JVM�� ���ϰų� ���� ������ ���� ���� �� ��������� �ȴ�.
	@Override
	protected void finalize() throws Throwable {
		System.out.print("");
	}	
	
}
