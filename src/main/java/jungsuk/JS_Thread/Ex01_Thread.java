package jungsuk.JS_Thread;

//두 가지의 Thread 구현 방법
public class Ex01_Thread {
    public static void main(String[] args) {
        ThreadEx1 t1 = new ThreadEx1();

        //Runnarable interface를 구현하는 방법은 다른 클래스를 상속받을 수 있고,
        //재사용성(Reusability)이 높고 consistency를 유지할 수 있기 때문에 일반적으로 사용한다.
        Runnable r = new ThreadEx2();
        Thread t2 = new Thread(r); // Constructor Thread(Runnable target)

        t1.start();
        t2.start();

        //같은 쓰레드를 또 실행하는 경우
        //t1.start(); 의 경우 IllegalThreadStateException 발생
        t1 = new ThreadEx1(); //다시 생성.
        t1.start();

        r = new ThreadEx3();
        Thread t3 = new Thread(r);
        t3.start();
    }
}

class ThreadEx1 extends Thread {
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("|"); //조상인 Thread의 getName() 호출
        }
    }
}

class ThreadEx2 extends Thread {
    public void run() {
        //ThreadcurruntThread() - 현재 실행중인 Thread를 반환
        for(int i = 0; i < 5; i++) {
            System.out.println("-");
        }
    }
}

//고의로 예외 발생시키기.
class ThreadEx3 extends Thread {
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}