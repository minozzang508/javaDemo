package jungsuk;

/**
 * Created by minho on 2017-06-15.
 */

//1. import문은 root부터 작성.
//밑에 두 import 문 실행 시 성능 차이는 없다.
import jungsuk.JS_08_Inheritance;
import jungsuk.*;

//2. static import : static member를 호출할 때 클래스의 이름을 생략할 수 있다.
// 특정 클래스의 static 멤버를 자주 사용할 때 편리하다.
import static java.lang.Integer.parseInt;
import static java.lang.Math.random;

public class JS_09_Import {
    public static void main(String[] args) {
        //static import로 Math 클래스 이름 생략 가능.
        System.out.println(Math.random());
        System.out.println(random());

        String s = "365";
        int a = parseInt(s); // import static으로 "Integer" 클래스 생략.

    }
}
