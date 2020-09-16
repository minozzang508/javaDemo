package jungsuk;

/**
 * Created by minho on 2017-06-14.
 */

public class JS_06_Overloading {
    static int add(int a, int b) {
        return a + b;
    }

    //first overloading
    static int add(int a, int b, int c) {
        return a + b + c;
    }

    //second overloading
    static double add(double a, double b) {
        return a + b;
    }

    //variable arguments
    static int add(int... args) {
        int res = 0;
        for (int i = 0; i < args.length; i++) {
            res += args[i];
        }
        return res;
    }

    static double add(double... args) {
        int res = 0;
        for (int i = 0; i < args.length; i++) {
            res += args[i];
        }
        return res;
    }

    public double add(float... f) {
        return 3.0d;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 3));
        System.out.println(add(1, 2, 3, 4));

        for (int i = 0; i < 10; i++) {

        }
    }
}
