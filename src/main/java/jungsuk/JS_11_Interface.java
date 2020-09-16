package jungsuk;

/**
 * Created by minho on 2017-06-15.
 */

/**
 * Interface의 장점
 * 1. 개발시간을 단축시킬 수 있다.
 * 2. 표준화가 가능하다.
 * 3. 서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다.
 * 4. 독립적인 프로그래밍이 가능하다.
 */

//abstract class 와 interface의 차이
//interface의 추상화 정도가 더 심해 상수, 추상메서드 외 어떤 요소도 허용하지 않는다.
public interface JS_11_Interface {
    //멤버변수는 public static final (생략 가능)
    public static final int memberVeriable = 10;

    //method는 public abstract (생략 가능)
    //* static method와 default method는 예외.(JDK 1.8부터 변경)
    //1. 추상매서드 (public abstract 생략 가능)
    public abstract void method(int... params);

    //2. default method.
    default void defaultMethod() {
        System.out.println("This is default method.");
    }

    //3. static method
    static void staticMethod() {
        System.out.println("This is static method");
    }
}


