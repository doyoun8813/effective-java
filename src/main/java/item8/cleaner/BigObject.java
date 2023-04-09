package item8.cleaner;

import java.util.List;

public class BigObject {

	// BigObject�� ������ �� ������ �Ǿ�� �ϴ� ���ҽ�
	private List<Object> resource;
	
	public BigObject(List<Object> resource) {
		this.resource = resource;
	}
	
	// resource �����ϴ� ��ü ������ Runnable task�� ���� finalize�� ����
	// static inner class�� ����
	// �ش� ��ü �ȿ� BigObject ���� ����. �����Ϸ��� �� �� ������ �ϸ� ��Ȱ�ϰ� �� �� �ִ�.
	public static class ResourceCleaner implements Runnable {
		
		private List<Object> resourceToClean;
		
		public ResourceCleaner(List<Object> resourceToClean) {
			this.resourceToClean = resourceToClean;
		}

		@Override
		public void run() {
			resourceToClean = null;
			System.out.println("clened up.");
		}
		
	}// end of inner class
	
}// end of class
