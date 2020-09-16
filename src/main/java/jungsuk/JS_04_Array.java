package jungsuk;

/**
 * Created by minho on 2017-06-14.
 */
public class JS_04_Array {
    public static void main(String[] args) {
        //배열의 복사는 for문보다 System.arraycopy()를 사용하는 것이 효율적이다.
        int[] iAry = {1, 2, 3, 4, 5};
        int[] iAry2 = new int[iAry.length * 2];
        System.arraycopy(iAry, 0, iAry2, 5, iAry.length);
        System.arraycopy(iAry, 0, iAry2, 0, iAry.length);

        for(int tmp : iAry2) {
            System.out.println(tmp);
        }

        System.out.println();

        //Array of String
        //1. String의 기본 값.
        String s = null;
        System.out.println(s);
        //2. String class는 'array of char'에 기능을 추가한 것이다.
        s = "minozzang";
        char[] mino = s.toCharArray();

        System.out.println(mino);
        System.out.println(new String(mino));
        System.out.println(new String(s));
        System.out.println("minozzang");

        new String(s);

        System.out.println();
        //Multi-dimensional array.
        //1. 가변 배열
        int [][] score = new int[5][];
        score[0] = new int[4];
        score[1] = new int [7];
        score[2] = new int [3];
        score[3] = new int [2];
        score[4] = new int[3];

        for(int i = 0; i < score.length; i++) {
            System.out.println(score[i].length);
        }

        int [][][] demension3 = new int[5][2][3];

        demension3[0][0][2] = 10;
        demension3[0][1][0] = 11;
        //차수 맞춰서 접근!
    }
}
