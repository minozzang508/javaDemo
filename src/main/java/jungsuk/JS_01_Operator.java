package jungsuk;

import static java.lang.Integer.toBinaryString;

/**
 * Created by minho on 2017-06-13.
 */


public class JS_01_Operator {


    public int gloInt = 10;
    public static void main(String[] args) {
        //Bitwise operator
        //1. int type bitwise operation
        int x = 3;
        int y = ~x;
        System.out.println(y); // ~3 == -4 : int 3의 보수
        System.out.println(x << 2);

        System.out.println("~~~-65 = " + ~~-65);
        System.out.println("(char)~(int)(char)~65 = " + (char)~(int)(char)~65);

        int res = 0xAB | 0xF;
        System.out.println(Integer.toHexString(res).toUpperCase()); // 0xAB | 0xF == 0xAF

        res = 0xAB ^ 0xF;
        System.out.println(Integer.toHexString(res).toUpperCase()); // 0xAB ^ 0xF == 0xA4

        res = 3 ^ 4;
        System.out.println("3 ^ 4 = " + res);

        //2. boolean bitwise operation.
        boolean b = true;
        System.out.println(b | false);
        System.out.println(b & false);

        //3. shift operator
        // <<, >>
        //3-1. x << n == x * 2^n의 결과와 같다.
        //     x >> n == x / 2^n의 결과와 같다.

        System.out.println(x << 2); // x == 3;

        char c = 'A';
        int i = c;
        System.out.println(i);

        System.out.println(Integer.toHexString(i));

        char ch = 65;
        System.out.println(ch);

        double d = 66.0;

        ch = (char)d;
        System.out.println(ch);
        ch = (char)65.0;
        System.out.println(ch);
        System.out.println(toBinaryString((int)d));
        System.out.printf("%32s\n", toBinaryString(65));
    }
}
