package jungsuk;

/**
 * Created by minho on 2017-06-14.
 */
public class JS_03_Loop {
    public static void main(String[] args) {
        //초기화, 조건식, 증감식 모두 생략한 for-loop
        int i = 0;
        for(;;) {
            if(i == 3) break;
            System.out.println(i);
            i++;
        }

        //두 개의 변수
        int j;
        for(j = 10, i = 0; i < 10; i++, j--) {
            System.out.println("i = " + i + ", j = " + j);
        }
        //for(i = 0, int j = 10; <- error...

        //Enhanced for statement
        int [] arr = {1, 2, 3, 4, 5};
        for(int tmp : arr) {
            System.out.println(tmp);
        }

        //continue
        for(i = 0; i < 111; i++) {
            if(i % 10 != 0)
                continue;
            System.out.println(i);
        }

        int[] iAry = new int[1000];

        for(int x=0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {
                for(int z = 0; z < 10; z++) {
                    System.out.println("" + x + y + z);
                    iAry[Integer.parseInt("" + x + y + z)] = Integer.parseInt("" + x + y + z);
                }
            }
        }

        System.out.println(iAry[200]);
        System.out.println(2_000_000);
        System.out.println(2_1_0);
    }
}
