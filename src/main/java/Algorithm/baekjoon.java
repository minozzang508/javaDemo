package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class baekjoon1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] croAlpha = new String[8];

        croAlpha[0] = "c=";
        croAlpha[1] = "c-";
        croAlpha[2] = "dz=";
        croAlpha[3] = "d-";
        croAlpha[4] = "lj";
        croAlpha[5] = "nj";
        croAlpha[6] = "s=";
        croAlpha[7] = "z=";

        String string = s.nextLine();
        String res = string;

        int cnt = 0;

        for(int i = 0; i < croAlpha.length; i++) {
            if(string.contains(croAlpha[i])) {
                string = string.replace(croAlpha[i], " ");
            }
        }

        System.out.println(string.length());
    }
}


class baekjoon2 {
    static void findPath(Test t) {
        int tmp = t.W;

        int cnt = 0;
    }
    public static class xy {
        int x;
        int y;

        public xy() {
        }
    }
    public static class Test {
        int N, K;
        int[] D;
        xy[] XY;
        int W;

        public Test() {
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        Test[] tCase = new Test[T];

        int[] answer = new int[T];

        for(int i = 0; i < T; i++) {
            tCase[i] = new Test();
            tCase[i].N = s.nextInt();
            tCase[i].K = s.nextInt();

            tCase[i].D = new int[tCase[i].N];
            for(int j = 0; j < tCase[i].N; j++) {

                tCase[i].D[j] = s.nextInt();
            }

            tCase[i].XY = new xy[tCase[i].K];
            for(int m = 0; m < tCase[i].K + 1; m++){
                tCase[i].XY[m] = new xy();
                tCase[i].XY[m].x = s.nextInt();
                tCase[i].XY[m].y = s.nextInt();
            }

            tCase[i].W = s.nextInt();

            findPath(tCase[i]);
        }
    }
}

class baekjoon3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String input = s.next();
        int frontAxis = 0;
        int backAxis = input.length() - 1;
        boolean tmp = false;
        int cnt = 0;

        System.out.println(frontAxis);
        System.out.println(backAxis);
        while (frontAxis != backAxis) {
            for(int i = frontAxis; i < (backAxis - frontAxis) / 2; i++) {
                System.out.println(backAxis - frontAxis + 1);
                if(input.charAt(i) == input.charAt(backAxis - i) && i == backAxis - frontAxis / 2 + 1) {
                    cnt++;
                    frontAxis = backAxis;
                    break;
                }else {
                    backAxis--;
                }
            }
            backAxis = input.length() - 1;
        }

        System.out.println(cnt);
    }
}

class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String str=sc.nextLine();

        isPalindrome(str);

    }
    private static void isPalindrome(String str){
        int length = str.length();
        int count = 0;
        String subStr = "";
        String reversStr = "";
        ArrayList<String> subArr = new ArrayList<>();
        for(int i = 0; i < length; i++){
            for(int j = length; j > i; j--){
                subStr = str.substring(i,j);

                reversStr=reverse(subStr);

                if(subStr.equals(reversStr)&&subStr.length() >= 2) {
                    //System.out.println(subStr);
                    subArr.add(subStr);
                    count++;
                    i = j-1;
                    break;
                }else if(subStr.length()==1){
                    Loop1 : for(String data:subArr){
                        for(int l=0;l<data.length();l++) {
                            if (data.charAt(l) == subStr.charAt(0)) {
                                break Loop1;
                            }
                        }
                    }
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    private static String reverse(String str){
        return new StringBuffer(str).reverse().toString();
    }
}