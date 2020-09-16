package jungsuk;

/**
 * Created by minho on 2017-06-19.
 */

/**
 * Inner class의 장점
 * (Encapsulation)
 * 1. 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다.
 * 2. 코드의 복잡성을 줄일 수 있다.
 */

class InnerEx1 {
    class InstanceInner {
        int iv = 100;
        //          static int cv = 100;            // Error! static변수를 선언할 수 없다.
        final static int CONST = 100;   // final static은 상수이므로 허용한다.
    }

    static class StaticInner {
        int iv = 200;
        static int cv = 200;       // static클래스만 static 멤버를 정의할 수 있다.
    }

    void myMethod() {
        class LocalInner {
            int iv = 300;
            //                static int cv = 300;          // Error! static 변수를 선언할 수 없다.
            final static int CONST = 300; // final static은 상수이므로 허용.
        }
    }
}

public class JS_12_InnerClass {
    public static void main(String[] args) {
        System.out.println(InnerEx1.InstanceInner.CONST);
        System.out.println(InnerEx1.StaticInner.cv);
    }
}
