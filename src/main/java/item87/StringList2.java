package item87;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StringList2 implements Serializable {
    private transient int size = 0;
    private transient Entry head = null;

    private static class Entry{
        String data;
        Entry next;
        Entry previous;
    }

    public final void add(String s){
    }

    /**
     * StringList 인스턴스를 직렬화한다.
     * @serialData 이 리스트의 크기(포함된 문자열의 개수)를 기록한 후, 이어서 모든 원소를 순서대로 기록한다.
     */
    private void writeobject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        // 모든 원소를 올바른 순서로 기록
        for (Entry e = head; e != null; e = e.next)
            s.writeObject(e.data);
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        // 모든 원소를 읽어 이 리스트에 삽입
        for (int i = 0; i < numElements; i++)
            add((String)s.readObject());
    }
}
