package item13;

import java.util.Iterator;

public class HashTable implements Cloneable {
	
	// HashTable�� ��Ŷ
	private Entry[] buckets = new Entry[10];
	
	// ��Ŷ ������ LinkedList
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
		
		// ������� �Լ� ������ ����� ������ ����� �迭�� ������ StackOverFlow�� �� �� �ִ�.
//		public Entry deepCopy() {
//			return new Entry(key, value, next == null ? null : next.deepCopy());
//		}

		// StackOverFlow�� ������ ���
//		public Entry deepCopy() {
//			Entry result = new Entry(key, value, next);
//			
//			for(Entry p = result; p.next != null; p = p.next) {
//				p.next = new Entry(p.next.key, p.next.value, p.next.next);
//			}
//			
//			return result;
//		}
		
		// deepCopy �޼��� ���� clone�� �ٽ� ����ϸ� �ȵɱ�?
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
//			// bukets�� ������ �� ���ο� LinkedList Entry�� ������ ����, ���纻 �Ȱ���.
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
			// ���� HashTable�� ���� ũ���� ��Ŷ�� ���� �����
            // ������ ������ ���� ��Ŷ�� ���� ��Ŷ�� �ִ� Entry ��ü�� ����
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
