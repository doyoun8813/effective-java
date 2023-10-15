package item69;

public class App {

    // 흐름제어용 반복문
    public void Loop1() {
        Mountain[] range = new Mountain[10];

        try {

            int i = 0;
            while (true) {
                range[i++].climb();
            }

        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    // 정상적인 반복문
    public void Loop2() {
        Mountain[] range = new Mountain[10];

        for (Mountain m : range)
            m.climb();
    }

    private static class Mountain {
        public void climb() {
            System.out.println("1");
        }
    }
}



