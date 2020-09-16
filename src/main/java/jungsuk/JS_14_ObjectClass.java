package jungsuk;

/**
 * Created by minho on 2017-06-19.
 */

class Value implements Cloneable { //Cloneable 인터페이스를 구현한 클래스에스에서만 clone() 메서드를 호출할 수 있다.
    int a;

    Value () {
        this.a = 0;
    }
    Value(int a) {
        this.a = a;
    }

    //equals 메서드 Overriding.
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Value) {
            return this.a == ((Value)obj).a;
        } else {
            return false;
        }
    }

    //clone() method Overriding.
    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone(); // clone은 반드시 예외처리를 해주어야 한다.
        } catch (CloneNotSupportedException e) {}

        return obj;
    }

    //공변 반환 타입(Covariant return type) JDK 1.5 이후
    //조상 메서드의 반환타입을 자손 클래스의 타입으로 변경을 허용하는 것이다.
    //ShallowCopy - Call by Reference의 주소를 복사하여 값이 같이 변경된다.
    public Value shallowCopy() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}

        return (Value)obj;
        //조상 타입이 아닌, 자손 객체의 타입으로 반환할 수 있어서 번거로운 형변환이 줄어든다.
    }
    //DeepCopy - Call by reference의 값을 복사하여 값이 같이 변경되지 않는다.
    public Value deepCopy() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}

        Value v = (Value)obj;
        v.a = ((Value) obj).a;

        return v;
    }
}

public class JS_14_ObjectClass {

    public static void main(String[] args) throws Exception {
        //1. equals(obj)
        //  같은 값인지 비교하려면 equals 메서드를 Overriding 하자
        Value a = new Value(5);
        Value b = new Value(5);

        System.out.println(a.equals(b));
        a = b;
        System.out.println(a.equals(b));

        b.a = 3;
        System.out.println(a.a);
        System.out.println(b.a);

        //2.hashCode()
        String s1 = "abc";
        String s2 = "abc";

        System.out.println(s1.equals(s2));

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        Value c = new Value(5);
        Value d = new Value(5);
        //같은 값이어도 다른 hashCode.
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());

        //3. toString();
        // 알맞게 수정하려면 Overriding 하자!
        System.out.println(c.toString());
        System.out.println(d.toString());

        //4.clone()
        Value e = (Value)d.clone();
        System.out.println(e.a);


        //Shallow - Deep
        Value v0 = new Value(1);
        Value v1 = v0.shallowCopy();
        Value v2 = v0.deepCopy();

        //reference 변수를 Value 클래스에 추가해서 비교해보기.

        //5, getClass() - 자신이 속한 클래스의 Class 객체를 반환하는 메서드
        Class vObj = new Value(2).getClass();
        System.out.println(vObj.getSimpleName());

        Value x = Value.class.newInstance();
    }
}
