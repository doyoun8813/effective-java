package item13;

import java.util.Iterator;

public class HashTable implements Cloneable {
	
	// HashTable의 버킷
	private Entry[] buckets = new Entry[10];
	
	// 버킷 내부의 LinkedList
	private static class Entry implements Cloneable {
		final Object key;
		Object value;
		Entry next;
		
		Entry(Object key, Object value, Entry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public void add(Object key, Object value) {
			this.next = new Entry(key, value, null);
		}
		
		// 재귀적임 함수 동작은 제대로 되지만 연결된 배열이 많으면 StackOverFlow가 날 수 있다.
//		public Entry deepCopy() {
//			return new Entry(key, value, next == null ? null : next.deepCopy());
//		}

		// StackOverFlow에 안전한 방법
//		public Entry deepCopy() {
//			Entry result = new Entry(key, value, next);
//			
//			for(Entry p = result; p.next != null; p = p.next) {
//				p.next = new Entry(p.next.key, p.next.value, p.next.next);
//			}
//			
//			return result;
//		}
		
		// deepCopy 메서드 말고 clone을 다시 사용하면 안될까?
		@Override
		public Entry clone() {
			try {
				return (Entry) super.clone();
			} catch (CloneNotSupportedException e) {
				throw new AssertionError();
			}
		}
				
	}
	
//	@Override
//	public HashTable clone() {
//		HashTable result = null;
//		
//		try {
//			result = (HashTable) super.clone();
//			// bukets만 복사할 뿐 내부에 LinkedList Entry는 여전히 원본, 복사본 똑같다.
//			result.buckets = this.buckets.clone(); // shallow copy
//			return result;
//		} catch (CloneNotSupportedException e) {
//			throw new AssertionError();
//		}
//		
//	}
	
	@Override
	public HashTable clone() {
		HashTable result = null;
		
		try {
			result = (HashTable) super.clone();
			// 원본 HashTable과 같은 크기의 버킷을 새로 만들고
            // 내용이 있으면 복사 버킷에 원본 버킷에 있는 Entry 객체를 복사
			result.buckets = new Entry[this.buckets.length];
			for (int i = 0; i < this.buckets.length; i++) {
				if(buckets[i] != null) {
					//result.buckets[i] = this.buckets[i].deepCopy(); // deep copy
					result.buckets[i] = this.buckets[i].clone(); // clone
				}
			}
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
		
	}
	
	public static void main(String[] args) {
		
		HashTable hashTable= new HashTable();
		Entry entry = new Entry(new Object(), new Object(), null);
		hashTable.buckets[0] = entry;
		HashTable clone = hashTable.clone();
		System.out.println(hashTable.buckets[0] == entry); // true
		System.out.println(hashTable.buckets[0] == clone.buckets[0]); // false
		System.out.println(hashTable.buckets[0].value == clone.buckets[0].value); // true
		System.out.println(clone.buckets[0].value.hashCode()); // 1252585652
		System.out.println(hashTable.buckets[0].value.hashCode()); // 1252585652
		clone.buckets[0].value = "hello";
		System.out.println(clone.buckets[0].value); // 1252585652
		System.out.println(hashTable.buckets[0].value); // 1252585652
		 
	} // end of main

} // end of class
