package item53;

public class App {

    static int sum(int... args){
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(App.sum(1,2,3));
    }
}
