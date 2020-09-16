package jungsuk;

/**
 * Created by minho on 2017-07-03.
 */
class Singleton {
    //getInstance() 메서드에서 사용될 수 있도록 인스턴스가 미리 생성되어야 하므로 static이어야 한다.
    static int a = 10;
    private static Singleton s = new Singleton();

    //static int a = 10이 여기에 있으면.. 10 출력댐.!!

    //외부에서 생성자를 직접 사용하지 못하게 함.
    private Singleton() {
        a = a + 10;
    }

    //인스턴스를 생성하지 않고도 호출할 수 있어야 하므로 static이어야 한다.
    public static Singleton getInstance() {
        if(s == null) {
            s = new Singleton();
        }
       // s = new Singleton();
        return s;
    }
    static int add(int x, int y) {
        return x + y;
    }
    int instanceAdd(int x, int y) {
        return x + y;
    }
}
public class JS_17_Singleton {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        System.out.println(s.a);
        Singleton s2 = Singleton.getInstance();
        System.out.println(s2.a);

        Singleton.getInstance();
        Singleton.getInstance();

        System.out.println(Singleton.a);

        System.out.println(s.instanceAdd(30, 20));

        System.out.println(Singleton.add(30, 20));

        System.out.println(Singleton.getInstance().instanceAdd(30, 20));

    }
}
