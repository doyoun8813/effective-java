package item8.cleaner;

import java.util.List;

public class BigObject {

	// BigObject가 없어질 때 정리가 되어야 하는 리소스
	private List<Object> resource;
	
	public BigObject(List<Object> resource) {
		this.resource = resource;
	}
	
	// resource 정리하는 객체 별도의 Runnable task로 정의 finalize의 역할
	// static inner class로 정의
	// 해당 객체 안에 BigObject 참조 금지. 삭제하려고 할 때 참조를 하면 부활하게 될 수 있다.
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
