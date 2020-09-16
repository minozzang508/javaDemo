package jungsuk;

import java.util.ArrayList;

/**
 * Created by minho on 2017-07-11.
 */

/**
 * ArrayList는 Vector를 개선한 것으로 구현원리와 기능적인 측면에서 동일하다.
 * 가능하면 ArrayList를 사용하자!
 *
 * 더 이상 저장할 공간이 없으면 보다 큰 새로운 배열을 생성해서 기존의 배열에 저장된 내용을 복사한 다음에 저장된다.
 */
public class JS_21_ArrayListEx1 {
    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
    }
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList(10);

        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        ArrayList list2 = new ArrayList(list1.subList(1,4));

        print(list1, list2);

    }
}
