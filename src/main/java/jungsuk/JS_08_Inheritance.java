package jungsuk;

/**
 * Created by minho on 2017-06-15.
 */
//모든 class의 parent class는 Object이다.
class Parent { //class Parent extends Object 생략.
    int age = 5;

    Parent () {
        //System.out.println("This is parent");
    }

    int show() {
        return this.age;
    }
}
class Child extends Parent{
    int age = 10;
    String usableTest = "why not";
    Child() {
        //System.out.println("This is Child");
    }
    Child(Parent p) {
        this.age = p.age;
    }

    //Overriding. (Same name, parameters, return type).
    //조상 클래스의 Access modifier보다 좁은 범위로 변경 불가. ex) public > protected > (default) > private
    //예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.
    int show() {
        //System.out.println("Overriding");
        return this.age;
    }
    //super(), super. <- 조상 클래스 접근자, 생성자 중복된 멤버 접근 할 때 위주로 사용하자.
}
class GrandChild extends Child {
    GrandChild() {
        //System.out.println("This is GrandChild");
    }
}
public class JS_08_Inheritance {
    static void doWork(Parent p) {
        if(p instanceof Child) {
            Child c = (Child)p;
        } else if (p instanceof GrandChild) {
            GrandChild gc = (GrandChild)p;
        }
    }
    public static void main(String[] args) {
        //1. Constructor를 호출하면 부모 생성자부터 호출된다.
        GrandChild g = new GrandChild();

        //2. Up casting OK!
        Parent p = new GrandChild();

        //3. Down casting new연산자와 동시에 불가!
        //GrandChild gc = (GrandChild)new Parent(); //ClassCastException
        //GrandChild gc = new Parent(); //Error!

        //4. instance member variables 변화.
        Parent a = new Parent();
        System.out.println(a.age);
        System.out.println(a.show());
        p = new Child();
        //왜 결과 값이 5, 10일까? - p.364
        //조상, 자손 클래스에 멤버변수가 중복정의되어있으면
        //참조변수 타입을 따라간다!!
        System.out.println(p.age);
        System.out.println(p.show());
        //Down casting. 형변환 생략 불가!
        Child c = (Child) p;
        System.out.println(c.age);
        System.out.println(c.show());
        p = c;
        System.out.println(p.age);
        System.out.println(p.show());

        //5. instanceof operator - 참조변수가 참조하고 있는 인스턴스의 실제 타입이 무엇인지 return.
        doWork(p);
        System.out.println(p.age);
        System.out.println(p.show());

        Parent pTest = new Child();
        Child cTest = new Child();
        //System.out.println(pTest.useableTest); //error;
        System.out.println(cTest.usableTest);

        System.out.println(pTest.getClass().getSimpleName());
        System.out.println(cTest.getClass().getSimpleName());


    }
}
