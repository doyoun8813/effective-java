package item42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<String> words = new ArrayList<>();

        // 익명 클래스
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        // 람다식
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        // 메서드 레퍼런스 활용
        Collections.sort(words, Comparator.comparingInt(String::length));

        words.sort(Comparator.comparingInt(String::length));
    }

}
