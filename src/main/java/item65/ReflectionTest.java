package item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class ReflectionTest {

    /*명령 인수 첫번째는 Set을 구현한 구현채, 두번째 부터 출력할 문자열을 인수로 지정한다.*/

    public static void main(String[] args) {
        Class<? extends Set<String>> cl = null;

        try {
            cl = (Class<? extends Set<String>>)
                    Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            fatalError("ClassNotFoundException");
        }

        Constructor<? extends Set<String>> cons = null;
        
        try {
            cons = cl.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fatalError("NoSuchMethodException");
        }

        Set<String> s = null;
        try {
            s = cons.newInstance();
        } catch (IllegalAccessException e){
            fatalError("IllegalAccessException");
        } catch (InstantiationException e){
            fatalError("InstantiationException");
        } catch (InvocationTargetException e){
            fatalError("InvocationTargetException:" + e.getCause());
        } catch (ClassCastException e){
            fatalError("ClassCastException");
        }

        s.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(s);
    }

    private static void fatalError(String msg) {
        System.err.println(msg);
        System.exit(1);
    }

}
