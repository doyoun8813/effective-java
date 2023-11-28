package item90;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public final class Period implements Serializable {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if(this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
    }

    public Date start() { return new Date(start.getTime()); }
    public Date end() { return new Date(end.getTime()); }
    public String toString() { return start + " - " + end; }

    // 직렬화 프록시 패턴용 writeReplace 메서드
    private void readObject(ObjectInputStream stream) throws IOException {
        throw new InvalidObjectException("프록시가 필요합니다.");
    }

    // 직렬화 프록시 패턴용 writeReplace 메서드
    private Object writeReplace(){
        return new SerializationProxy(this);
    }

    // Period 클래스용 직렬화 프록시
    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        SerializationProxy(Period period){
            this.start = period.start;
            this.end = period.end;
        }

        private static final long serialVersionUID = 1L;

        // Period.SerializationProxy용 readResolve 메서드
        private Object readResolve(){
            return new Period(start, end);
        }
    }
}
