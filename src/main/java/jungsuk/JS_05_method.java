package jungsuk;

/**
 * Created by minho on 2017-06-14.
 */

class TestClass {
    int instanceVariable;
    static int classVariable;

    public TestClass() {
//        instanceMethod2();
//        classMethod2();

        this.instanceVariable = 3;
        classVariable = 2;
    }

    void instanceMethod() {
        this.instanceVariable = 0;
        classVariable = 1; //class variable 사용 가능
    }
    static void classMethod() {
        //class method에서는 super, this를 사용 불가.
        classVariable = 1;
        //class method에서는 instanceVariable 사용 불가.
    }

    void instanceMethod2() {
        instanceMethod();
        classMethod();
        System.out.println("This is instance method!");
    }

    static void classMethod2() {
        //class method에서는 instance method를 호출할 수 없다.
        //instanceMethod(); //Error!! can not call instance method!!
        classMethod();

        System.out.println("This is class method!");
    }
}

public class JS_05_method {
    public static void main(String[] args) {
        //참조변수 선언 없이 instance 생성하여 인스턴스 메서드 호출 가능.
        new TestClass().instanceMethod2();

        TestClass t = new TestClass();
        t.instanceMethod();
        //클래스 메서드는 인스턴스 생성 없이 호출 가능.
        TestClass.classMethod2();
    }
}
