package item53;

public class App2 {

    static int min(int... args){
        if(args.length == 0){
            throw new IllegalArgumentException("인수가 1개이상 필요합니다.");
        }
        int min = args[0];

        for (int i = 1; i < args.length; i++) {
            if(args[i] < min){
                min = args[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(min(4,2,7,10));
        System.out.println(min());
    }
}
