package item53;

public class App3 {

    static int min(int firstArg, int... remainingArgs){
        int min = firstArg;

        for (int arg : remainingArgs) {
            if (arg < min)
                min = arg;
        }
        return min;
    }

    public void foo() { }
    public void foo(int a1) { }
    public void foo(int a1, int a2) { }
    public void foo(int a1, int a2, int a3) { }
    public void foo(int a1, int a2, int a3, int... rest) { }



    public static void main(String[] args) {
        System.out.println(min(10, 20, 30, 1, 40));
        System.out.println(min(4));
    }
}
