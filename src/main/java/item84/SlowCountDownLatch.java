package item84;

public class SlowCountDownLatch {
    private int count;

    public SlowCountDownLatch(int count) {
        if(count < 0){
            throw new IllegalArgumentException(count + " < 0");
        }
        this.count = count;
    }

    public void await() {
        while(true){ // 무한루프 조건 충족 검사
            synchronized (this){
                if (count == 0)
                    return;
            }
        }
    }

    public synchronized void coundDown() {
        if (count != 0)
            count--;
    }
}
