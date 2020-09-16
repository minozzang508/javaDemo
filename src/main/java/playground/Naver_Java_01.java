package playground;

/**
 * Created by minho on 2017-06-14.
 */

class parent {
    int i = 5;

    public parent() {
        System.out.println("parent");
    }

    public parent(int i) {
        this.i = i;
    }
    public int show() {
        return this.i;
    }
}
class child extends parent {
    int i = 10;

    public child() {
        System.out.println("child");
    }

    public child(int i) {
        this.i = i;
    }

    public int show() {
        return this.i;
    }
}

class grandChild extends child {
    char c = 'c';

    public grandChild() {
        System.out.println("grandChild");
    }
}

public class Naver_Java_01
{
    public static void main(String[] args) {
        int i = 10;
        grandChild grand = new grandChild();

        parent p = new child(i);
        System.out.println(p.i);
        System.out.println(p.show());

        child c = new child(i);
        System.out.println(c.i);
        System.out.println(c.show());

        parent a = new parent();
        System.out.println(a.i);
        System.out.println(a.show());

        child b = new child();



    }

}
