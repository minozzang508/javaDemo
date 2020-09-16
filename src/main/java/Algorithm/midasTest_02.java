package Algorithm;

// don't place package name.

import java.io.*;
import java.util.*;

// don't change 'Program' class name and without 'public' accessor.
class Program_01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int M = s.nextInt();

        int maxLength = 0;

        int[] dduck = new int[M];
        int[] temp = new int[M];

        int cnt = 0;

        for(int i=0; i< M; i++) {
            dduck[i] = s.nextInt();
        }

        for(int length = 1; length <= dduck[0]; length++) {
            cnt = 0;

            for(int j = 0; j<dduck.length; j++) {
                temp[j] = dduck[j] / length;
                cnt += temp[j];
            }

            if(N <= cnt) {
                if(maxLength < length) {
                    maxLength = length;
                }
            }
        }

        System.out.println(maxLength);
    }
}

class Program_02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        boolean flag = false;
        Random rand = new Random();
        int tmp;

        int N = s.nextInt();
        int[] arr=new int[N]; // 입력된 배열
        int[] temp =new int[N];

        //배열 입력
        for(int i = 0; i < arr.length; i++){
            arr[i]=Integer.parseInt(s.next());
            temp[i]=arr[i];
        }

        Arrays.sort(temp);
        reverseAry(temp);

        for(int i = 0; i < arr.length; i++) {
            if(temp[i] == arr[i]){
                flag = true;
            }else {
                flag = false;
            }
        }

        if(flag)
            System.out.println(-1);
        else{
            int n = arr.length;

            for(int i = 0; i < arr.length; i++){
                int random = rand.nextInt(n);
                tmp = arr[i];
                arr[i] = arr[random];
                arr[random] = tmp;
            }

            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
        }
    }

    //
    static void reverseAry(int[] ary) {
        int temp;

        for (int i = 0; i < ary.length / 2; i++) {
            temp = ary[i];
            ary[i] = ary[(ary.length - 1) - i];
            ary[(ary.length - 1) - i] = temp;
        }
    }
}

class Program_03 {
    //서로소 판별.
    static boolean isDisjoint (int n, int m) {
        for(int i = 2; i <= n; i++) {
            if(n % i == 0 && m % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        int[] N = new int[T];
        int[][] A = new int[T][];
        boolean[] answer = new boolean[T];

        for(int i = 0; i < T; i++) {
            N[i] = s.nextInt();
            A[i] = new int[N[i]];
            for(int j = 0; j < N[i]; j++) {
                A[i][j] = s.nextInt();
            }
            answer[i] = false;
        }

        for(int i = 0; i < T; i++) {
            loop1 : for (int j = 0; j < N[i]; j++) {
                for(int k = j + 1; k < N[i]; k++) {
                    if(A[i][j] != A[i][k]) {
                        answer[i] = answer[i] || isDisjoint(A[i][j], A[i][k]);
                        if(answer[i] == true) {
                            break loop1;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < T; i++) {
            if(answer[i] == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

class Program_04 {
    //농장 크기
    static final int MAX = 101;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //사과나무 개수
        int N = s.nextInt();
        //사과당 사과 개수
        int M = s.nextInt();

        final int dx[] = {-1, 1, 0, 0,};
        final int dy[] = {0, 0, 1, -1};

        int x = 0,y = 0;

        //이동좌표
        int cx = 0, cy = 0;

        //수확가능한 총 사과수
        int total = 0;

        // 사과나무 위치
        int[][] position = new int[MAX][MAX];

        Queue<Integer> qX = new LinkedList<>();
        Queue<Integer> qY = new LinkedList<>();

        Queue<Integer> xAry  = new LinkedList<>();
        Queue<Integer> yAry = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            int posX = s.nextInt();
            int posY = s.nextInt();
            xAry.add(posX);
            yAry.add(posY);
        }


        qX.add(0);
        qY.add(0);

        while(!qX.isEmpty() && !qY.isEmpty()) {
            x = qX.poll();
            y = qY.poll();

            for(int i = 0; i < 4; i++) {
                cx = x + dx[i];
                cy = y + dy[i];

                //좌표 범위 검사
                if(cx >= 0 && cx < MAX && cy >= 0 && cy < MAX && position[cx][cy] == 0) {
                    position[cx][cy] = position[x][y] +1;
                    qX.add(cx);
                    qY.add(cy);
                }
            }
        }

        while(!xAry.isEmpty() && !yAry.isEmpty()) {
            x = xAry.poll();
            y = yAry.poll();

            if(position[x][y] < M) {
                total += M-position[x][y];
            }
        }

        System.out.println(total);
    }
}

class Program_05 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

    }
}

class Program_06 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int M = s.nextInt();

        char[] cList = new char[M];

        int cnt = 1;
        int tmp = 1;

        //자음
        List conList = new ArrayList();
        //모음
        List vowelList = new ArrayList();

        for(int i = 0; i < M; i++) {
            cList[i] = s.next().toCharArray()[0];
        }

        for(int i = 0; i < cList.length; i++) {
            if(cList[i] == 'a' || cList[i] == 'A' || cList[i] == 'e' || cList[i] == 'E' ||
                    cList[i] == 'i' || cList[i] == 'I' || cList[i] == 'o' || cList[i] == 'O' ||
                    cList[i] == 'u' || cList[i] == 'U') {
                conList.add(cList[i]);
            } else {
                vowelList.add(cList[i]);
            }
        }

        //nPm
        for(int i = M; i >= M - N; i--) {
            cnt = cnt * i;
        }
        for(int i = 1; i <= N; i++) {
            tmp = tmp * i;
        }

        cnt = cnt / tmp;

        System.out.println(cnt);
        System.out.println(conList.size());

    }
}