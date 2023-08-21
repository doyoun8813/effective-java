package item63;

public class StringTest {

    static String[] strArr = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    public static String statement() {
        String result ="";
        for (int i = 0, j = 0; i < 100000; i++) {
            result += strArr[j];
            if(j == strArr.length-1){
                j = 0;
                continue;
            }
            j++;
        }
        return result;
    }

    public static String statement2() {
        StringBuilder b = new StringBuilder(100000);
        for (int i = 0, j = 0; i < 100000; i++) {
            b.append(strArr[j]);
            if(j == strArr.length-1){
                j = 0;
                continue;
            }
            j++;
        }
        return b.toString();
    }

    public String statement3(){
        String str1 = "abc";
        String str2 = "def";
        String str3 = "ghi";

        String str4 = str1 + str2 + str3;
        return str4;
    }

    public static void main(String[] args) {
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        statement();
        endTime = System.currentTimeMillis();
        System.out.println("String : " + (endTime-startTime));

        long startTime2, endTime2;
        startTime2 = System.currentTimeMillis();
        statement2();
        endTime2 = System.currentTimeMillis();
        System.out.println("StringBuilder : " + (endTime2-startTime2));
    }
}
