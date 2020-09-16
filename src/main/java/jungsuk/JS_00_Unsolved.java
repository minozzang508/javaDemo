package jungsuk;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.TypeVariable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by minho on 2017-06-22.
 */
class test {
    static int iTest = 0;
    int id = 0;

    test() {
        this.iTest++;
        this.id = this.iTest;
    }

}
class test2 extends test {
    test2() {
        super();
        System.out.println("This is test2 type");
    }
}

//Overriding하는 조상 메서드가 private면 자손 메서드가 public 이어도 외부 클래스에서 호출 불가능
abstract class AAA {
    int a=10;

    protected void showInfo() {
        System.out.println(a);
    }

    abstract protected void volumeUp();
    protected void listenMusic() {}
}

class BBB extends AAA {
    int b=20;

    protected void showInfo() {
        System.out.println(b);
    }

    protected void showInfo2() {
        this.showInfo();
    }

    public void volumeUp() {
        System.out.println("볼륨업");
    }
}

public class JS_00_Unsolved {
    public static void main(String[] args) {
        //Atomic Integer
        AtomicInteger atomInt = new AtomicInteger(3);

        double atomDouble = atomInt.doubleValue();

        System.out.println(atomInt);
        System.out.println(atomDouble);

        //Wrapper classes
        Integer inTeg = 30;

        inTeg += 70;
        System.out.println(inTeg);

        //loop - new.
        for(int i = 0; i < 10; i++) {
            new test();
        }
        System.out.println("test.iTest = " + test.iTest);


        test tmp = new test();

        System.out.println(tmp.toString());

        AAA a = new BBB();
        a.showInfo();
        a.listenMusic();
    }
}
