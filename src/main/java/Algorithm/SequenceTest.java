package Algorithm;

import java.util.Scanner;
public class SequenceTest {
    public static void main(String[] args) {
        int data[] = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째 숫자 입력");
        data[0] = sc.nextInt();
        System.out.println("두번째 숫자 입력");
        data[1] = sc.nextInt();
        System.out.println("세번째 숫자 입력");
        data[2] = sc.nextInt();
        System.out.println("네번째 숫자 입력");
        data[3] = sc.nextInt();
        System.out.println("다섯번째 숫자 입력");
        data[4] = sc.nextInt();

        for(int i=0 ; i<data.length-1 ; i++){
            int min = i;
            for(int j=i+1 ; j<data.length ; j++){
                if(data[min] > data[j]){
                    int temp = data[min];
                    data[min] = data[j];
                    data[j] = temp;
                }
            }
        }

        System.out.println();
        for(int i=0 ; i<data.length ; i++)
            System.out.print(data[i] + " ");
        System.out.println();

        int temp[] = new int[4];
        for(int i=0 ; i<4 ; i++){
            temp[i] = data[i+1] - data[i];
        }

        if(((temp[3]-temp[2])==(temp[2]-temp[1])) && ((temp[2]-temp[1])==(temp[1]-temp[0]))){
            int result = data[4] + temp[3] + (temp[3]-temp[2]);
            System.out.println("개차수열 입니다.");
            System.out.println("다음 수는 "+result+"입니다.");
        }
        else
            System.out.println("개차수열이 아닙니다.");
    }
}

class SequenceTest2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int input = s.nextInt();

        int sum = 0;
        int tmp = 1;

        for(;;) {
            for(int i = 0; i < input; i++ ) {
                tmp += i;
                sum += tmp;
            }
            break;
        }


        System.out.println(sum);
    }
}

class Test3 {
    static double castingTest(float f) {
        return f;
    }
    static float castingTest2(float f) {
        return f;
    }
    public static void main(String[] args) {
        System.out.println(castingTest(3.14f));
        System.out.println(castingTest2(3.14f));
    }
}