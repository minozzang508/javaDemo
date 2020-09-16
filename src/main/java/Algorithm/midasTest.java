package Algorithm;
// don't place package name.

import java.io.*;
import java.util.*;

// don't change 'Program' class name and without 'public' accessor.

//1번 문제
//격자세계의 기차
//격자세계의 도시는 n by m 행렬로 나타내어진다. 각 행은 1부터 n까지 번호가, 각 열은 1부터 m까지 번호가 붙어있다.
//격자세계의 기차는 도시의 한 행을 수평으로 가로지른다. 즉, 격자세계의 기차는 두 끝위치(r, c1), (r,c2) 사이를 운행한다.
//r은 행 번호, c1과 c2는 열 번호를 뜻한다. 두 끝 지점도 운행 범위에 포함된다.
//총 k종류의 기차가 있다. 한 기차가 운행하는 범위는 다른 기차가 운행하는 범위와 겹칠 수도 있고, 겹치지 않을 수도 있다.
//격자세계의 도시에는 총 nm개의 지점들이 있다. 시장은 이 지점들 중 기차가 운행되지 않는 지점의 개수를 세려고 한다.
//
//입력
//첫째 줄에는 세 정수 n,m,k가 공백으로 구분되어 주어진다.
//이후 k개의 줄이 더 주어지고, 각 줄에는 각 기차의 정보를 뜻하는 세 정수 r, c1, c2가 공백으로 구분되어 중진다.
//
//출력
//기차가 운행되지 않는 지점의 개수를 출력하여라.
//
//제한조건
//    1 <= n,m <= 10
//    0 <= k <= 10
//    1 <= r <= n
//    1 <= c1 <= c2 <= m
class Program {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();

        int cnt = 0;

        cnt += (n - k) * 4;

        if(k != 0) {
            int[] r = new int[k];
            int[] c1 = new int[k] , c2 = new int[k];
            int[][] city = new int[n][m];

            for(int i = 0; i < k; k++) {
                r[i] = s.nextInt();
                c1[i] = s.nextInt();
                c2[i] = s.nextInt();
            }

            for(int i = 0; i < k; i++) {
                cnt += c2[i] - c1[i] + 1;
            }
        }

        System.out.println(cnt);
    }
}
class Program1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();

        int[][] train = new int[n][m];

        int[][] r = new int[k][3];
        int count = 0;

        for(int i = 0; i < k; i++) {
            for(int j = 0; j < 3; j++) {
                r[i][j] = s.nextInt();
            }
        }

        //train 지나가는 좌표.
        for(int i = 0; i < k; i++) {
            for(int j= r[i][1]; j<= r[i][2]; j++) {
                train[ r[i][0]-1 ][j-1] = 1;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(train[i][j] == 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

//2번 문제
class Program2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        String[] strings = new String[T];
        int[] answer = new int[T];

        while(T > 10 || T < 1) {
            System.out.print("T 값 재입력 : ");
            T = s.nextInt();
        }

        for (int i = 0; i < T; i++) {
            strings[i] = s.next();
            while(strings[i].length() < 1 || strings[i].length() > 10000) {
                System.out.println("텍스트 길이가 너무 김. 재입력하시오");
                strings[i] = s.next();
            }
            answer[i] = 0;
        }

        for(int i = 0; i < T; i++) {
            System.out.println(strings[i]);
        }

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < strings[i].length() / 2 ; j++) {
                //smaller char
                char temp = strings[i].charAt(j) >= strings[i].charAt(strings[i].length() - j - 1) ? strings[i].charAt(strings[i].length() - j - 1) : strings[i].charAt(j);
                //bigger char
                char temp2 = strings[i].charAt(j) > strings[i].charAt(strings[i].length() - j -1) ? strings[i].charAt(j) : strings[i].charAt(strings[i].length() - j - 1);
                while (temp != temp2) {
                    temp2--;
                    answer[i]++;
                }
            }
        }

        for(int i = 0; i < T; i++) {
            System.out.println(answer[i]);
        }
    }
}

//3번 문제
class Program3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int[] W = new int[N];
        int[] dp = new int[N + 1];

        int count = 0;

        for(int i=0; i<N; i++) {
            W[i] = s.nextInt();
        }

        for(int i=0; i<W.length;i++) {
            for(int j = i + 1; j < W.length; j++) {
                if(W[j] < W[i] +4  && W[j] > W[i]) {
                    dp[j] = dp[j - 1];
                }
                else {
                    dp[j] = dp[j - 1] +1;
                    //index 이동
                    i = j;
                }
            }
        }

        System.out.println(dp[N - 1] + 1);
    }
}

//4번 문제
class Program4 {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }
    static int answer(int N, int[] dAry) {
        if(N < 3 || N > 100000) {
            System.out.println("N의 값을 제대로 입력하세요.");
            return 0;
        }
        //배열 각 수 차
        int[] distance = new int[N - 1];
        int GCD = 0;
        for(int i = 0; i < distance.length; i++) {
            distance[i] = dAry[i + 1] - dAry[i];
        }
        //GCD
        GCD = gcd(distance[0], distance[1]);
        for(int i = 1; i < distance.length - 1; i++) {
            GCD = gcd(GCD, distance[i+1]);
        }
        //return (first + last) / GCD + 1 - N
        return (dAry[N-1] - dAry[0]) / GCD + 1 - N;
    }

    public static void main(String[] args) {
        // 3 <= N <= 100000 입력

        //위치 1,3,7,13 입력

        //출력 - 3 (5, 9, 11)
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int[] dAry = new int[N];

        int answer = 0;

        for(int i = 0; i < N; i++) {
            dAry[i] = s.nextInt();
        }

        answer = answer(N, dAry);

        System.out.println(answer);

    }
}

//5번 문제

//6번 문제