package playground;

/**
 * Created by minho on 2017-07-03.
 */
class pTest {
    int i;
    static int si = 0;

    public pTest() {
        this.i = 1;
        si++;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class cTest extends pTest {
    int i;

    public cTest() {
        this.i = 2;
    }
}

class gcTest extends cTest {
    int i;

    public gcTest() {
        this.i = 3;
    }
}
public class classAryTest {
    public static void main(String[] args) {
        pTest[] pAry = new pTest[10];

        for(int i = 0; i < 10; i++) {
            if(i % 3 == 0) {
                pAry[i] = new pTest();
            } else if( i % 3 == 1) {
                pAry[i] = new cTest();
            } else {
                pAry[i] = new gcTest();
            }

            System.out.println(pAry[i].si);
            System.out.println("      " + pAry[i].getI());
            System.out.println("              " + pAry[i].i);
        }

        for(pTest tmp : pAry) {
            //System.out.println(tmp.getI());
            System.out.println(tmp.getClass().getSimpleName());
        }
    }
}
