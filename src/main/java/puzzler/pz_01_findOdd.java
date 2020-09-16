package puzzler;

/**
 * Created by minho on 2017-06-05.
 */

import java.math.BigDecimal;

public class pz_01_findOdd {
    //1. find odd number
    public static boolean isOdd(int i) {
        //incorrect answer
        //return i % 2 == 1;
        //(a/b) * b + (a % b) == a
        //를 만족하기 위해 a % b 연산의 결과은 항상 왼쪽 피연산자의 부호와 같다.
        //따라서 i 값이 음수이면 무조건 false 값을 리턴하게 된다.

        //correct answer
        //return i % 2 != 0;

        //isOdd 메서드의 성능이 크게 중요하다면..
        return (i & 1) != 0;

        //일반적으로 나누기 연산과 나머지 연산은 다른 사칙연산이나 논리 연산에 비해 느리다.

    }

    //2. 1.10달러짜리 사탕을 구매하고 2달러를 내고 계산했을 때, 그가 받을 거스름돈은 얼마인가?
    public static void SecondQuiz() {
        System.out.println("2 - 1.10 = " + (2.0 - 1.10));
        //result = 0.89999999999999999
        //reason : 모든 소수가 float 또는 double로 표현될 수 있는건 아니다. 따라서 금융 계산에 사용하면 안된다.
        //solution : JDB(Java Database Connectivity)에서 SQL DECIMAL 자료형으로 데이터를 처리하는 BigDecimal CLASS.
        //BigDecimal CLASS는 정확한 십진 연산을 수행한다.
        // * 유의사항 : BigDecimal(String) 생성자를 사용하자. double 생성자 사용 x.
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));

        //정확한 결과가 필요하다면 절대로 float이나 double 자료형을 사용하지 말자.
        //금융 계산 같은 곳에서는 반드시 int, long, BigDecimal 자료형을 사용하자.
    }

    //3. Long type division : 하루를 micro second 와 millis second로 나타낸 값으로 나누기.
    public static void longDivision() {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;

        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

        /*
        result : 1000 출력이 아니라 5 출력됨.

        reason : MICROS_PER_DAY가 Overflow되기 때문이다. long 자료형에 넣는 것은 문제가 아니고
        문제는 곱셈 연산이 int 자료형들끼리 이루어지며 이 부분에서 overflow가 발생한다.
        곱셈에 사용된 숫자들이 모두 int 자료형이기 때문.
        JAVA는 target typing을 지원하지 않으므로 결과 자료형이 long이라 해도 기존 자료형이 long 연산을 하지 않는다.

        solution : 곱셈에 사용되는 첫 번째 숫자를 long type으로 만들어 주면 다른 숫자도 long type으로 곱셈 수행.

        final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

        * Python 같은 경우는 연산 결과가 overflow되면 자동으로 type conversion 해준다.
        * overflow
        */
    }

    //4. 소문자 'l'과 숫자 '1'은 혼동되기 쉬우니 변수 이름으로 소문자'l'을 사용하지 말자.
    //long type 숫자를 나타낼 때도 대문자 'L'을 사용하자.

    //5. Joy of Hexadecimal : 16진수 2개를 더해서 16진수로 출력.
    public static void JoyOfHex() {
        System.out.println(Long.toHexString(0x100000000L + 0xcafebabe));
        /* result : 1cafebabe가 아니라 cafebabe를 출력한다. (33번째 비트 손실)
         * reason : 16진수나 8진수는 상위 비트(high-order bit)가 정의되면 음수로 인식한다.
         * 0xcafebabe를 상위 비트가 설정된 int 자료형의 값, 10진수로 -889275714가 된다.
         *
         * 또한 혼합 자료형 연산(mixed-type computation도 문제.
         * 자바에서는 int자료형이 long자료형으로 변환될 때 기본 자료형 확장 변환이 일어난다.
         * 0xcafebabe도 int자료형으로 부호가 있는 자료형이므로 부호확장(sign extension)이 함께 일어난다.
         * 따라서 long 자료형으로 변환되며 0xffffffffcafebabeL이 된다.
         *
         * 맨 마지막 33bit 부터 연산은 1 + (-1) 이므로 0이 된다. 최종적으로 연산은 0xcafebabe가 출력된다.
         * (64 bit를 넘어간 범위는 사라진다!)
         * */

        // solution : 16진수 값도 long 자료형이라는 것을 알 수 있게 L을 명시한다.
        System.out.println(Long.toHexString(0x100000000L + 0xcafebabeL));
    }

    //6. 다중 자료형 변환
    public static void multicast() {
        System.out.println("(char)~(int)(char)~65 = " + (char)~(int)(char)~65);
        System.out.println("(int) (char) (byte) -1 = " + (int) (char) (byte) -1);
    }

    public static void main(String[] args) {
        char c = 65;
        System.out.println(c);
        boolean tmp = isOdd(3);
        System.out.println(tmp);
        multicast();

        String s = null;
        int[] iAry = new int[3];

        System.out.println(s + iAry[2]);
    }
}
