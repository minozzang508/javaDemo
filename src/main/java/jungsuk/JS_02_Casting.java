package jungsuk;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by minho on 2017-06-13.
 */

public class JS_02_Casting {
    /*
        Primitive type에서 boolean을 제외한 나머지 타입들은 서로 Casting이 가능하다.

        Real number간의 Casting.
        double type에서 float type으로 Casting 하는 경우 가수 24번째 값이 1이면 반올림 발생.
     */


    public static void main(String[] args) {
        //1. float -> int 는 버림 연산.
        int i = (int)10.6f;
        System.out.println("i = " + i);

        //2. float의 최대값보다 큰 값을 double로 Casting 하면 무한대가 된다.
        double d1 = 1.0e100;
        float f1 = (float)d1;
        //3. float의 최소값보다 작은 값을 double로 Casting 하면 0이 된다.
        double d2 = 1.0e-50;
        float f2 = (float)d2;
        System.out.println(f1);
        System.out.println(f2);

        System.out.println(f1 - f1);

        //4.정수형과 실수형의 형변환.
        //정수형 -> 실수형 Casting 중 정밀도 차이에 의해 오차발생 할 수 있다.
        //float는 10진수로 7자리의 정밀도만 제공한다 따라서 double로 casting하자.
        int i4 = 91234567;
        int afterDoubleCasting = (int)(float) i4;
        System.out.println(afterDoubleCasting);


        //5.Auto casting
        //byte -> short , char -> int -> long -> float -> double
        //왼쪽에서 오른쪽으로의 변환은 auto casting이 되며 그 반대방향은 반드시 casting operator를 써줘야 한다
        //boolean을 제외한 나머지 7개의 기본형.



    }
}
