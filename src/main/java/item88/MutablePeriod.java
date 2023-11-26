package item88;

import java.io.*;
import java.util.Date;

public class MutablePeriod {

    // Period 인스턴스
    public final Period period;
    // 시작 시각 필드 - 외부에서 접근할 수 없어야 한다.
    public final Date start;
    // 종료 시각 필드 - 외부에서 접근할 수 없어야 한다.
    public final Date end;

    public MutablePeriod() {
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);

            // 유효한 Period 인스턴스 직렬화
            out.writeObject(new Period(new Date(), new Date()));

            // 악의적인 '이전 객체 참조
            byte[] ref = { 0x71, 0, 0x7e, 0, 5};
            bos.write(ref);
            ref[4] = 4;
            bos.write(ref);

            // Period 역직렬화 후 Date 참조를 훔친다.
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            period = (Period) in.readObject();
            start = (Date)  in.readObject();
            end = (Date) in.readObject();

        } catch (IOException | ClassNotFoundException exception){
            throw new AssertionError(exception);
        }
    }

    public static void main(String[] args) {
        MutablePeriod mp = new MutablePeriod();
        Period p = mp.period;
        Date pEnd = mp.end;

        pEnd.setYear(78);
        System.out.println(p);

        pEnd.setYear(69);
        System.out.println(p);
    }
}
