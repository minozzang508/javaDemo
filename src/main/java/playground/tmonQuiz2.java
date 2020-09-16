package playground;

import java.io.*;

/**
 * Created by minho on 2017-05-30.
 */


class wareHouse extends Thread {
    private String name;
    private int t1;
    private int t2;
    private int t3;
    private int t4;
    private int t5;
    private int numOfDrone;
    private int numOfActiveDrone;

    private int d1;
    private int d2;
    private int d3;
    private int d4;
    private int d5;

    private int totalDone;

    private int totalTime;

    private int[][] done;

    public wareHouse(String s, int t1, int t2, int t3, int t4, int t5, int numOfDrone) {
        this.name = s;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
        this.numOfDrone = numOfDrone;
        this.numOfActiveDrone = Thread.activeCount();
        this.done = new int[5][100];
    }

    public void Test(String orderNo, String des) {
        if(this.numOfActiveDrone >= this.numOfDrone)
            return;

        if(Integer.parseInt(des.substring(0, 1)) == 1) {

        }else if (Integer.parseInt(des.substring(0,1)) == 2) {

        }else if(Integer.parseInt(des.substring(0,1)) == 3) {

        }else if(Integer.parseInt(des.substring(0,1)) == 4) {

        }else {

        }
        this.numOfActiveDrone++;
    }
    public void run() {
        if(Thread.activeCount() < numOfDrone) {
            try {

            }catch(Exception e) {
                System.out.println(e);
            }
        }
        else {
            System.out.println(this.name + "드론 모두 사용중");
        }
    }

    public int getT1() {
        return t1;
    }

    public int getT2() {
        return t2;
    }

    public int getT3() {
        return t3;
    }

    public int getT4() {
        return t4;
    }

    public int getT5() {
        return t5;
    }

    public int getNumOfDrone() {
        return numOfDrone;
    }

    public int[][] getDone() {
        return done;
    }

    public int getD1() {
        return d1;
    }

    public int getD2() {
        return d2;
    }

    public int getD3() {
        return d3;
    }

    public int getD4() {
        return d4;
    }

    public int getD5() {
        return d5;
    }

    public int getTotalDone() {
        return totalDone;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setDone(int[][] done) {
        this.done = done;
    }

    private int getNumOfDone(int i) {
        if(i == 1)
            return getD1();
        else if(i == 2)
            return getD2();
        else if(i == 3)
            return getD3();
        else if(i == 4)
            return getD4();
        else
            return getD5();
    }



    public void showDone() {
        System.out.println(this.name);
        System.out.println("주문 처리 건수 " + getTotalDone() + "건");
        System.out.println("예상 소요 시간: " + getTotalTime() + "분");
        System.out.println("처리대상");
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < getNumOfDone(i); j++)
                System.out.println(done[i][j]);
        }
    }
}

public class tmonQuiz2 {
    public static void main(String[] args) {
        wareHouse A = new wareHouse("A창고", 10, 25, 30, 50, 60, 20);
        wareHouse B = new wareHouse("B창고", 20, 10, 20, 40, 55, 25);
        wareHouse C = new wareHouse("C창고", 60, 40, 25, 15, 20, 15);

        String [] orderNo = new String[100];
        String [] des = new String[100];
        int j = 0;

        String text = "";
        if (args.length == 0) {
            System.err.println("Input Order list...");
            System.exit(1);                         // 읽을 파일명을 주지 않았을 때는 종료
        }
        try {
            BufferedReader in = new BufferedReader(new FileReader(args[0]));
            String s;

            while ((s = in.readLine()) != null) {
                if(s.contentEquals("orderNo")) {
                    orderNo[j] = s.substring(s.length() - 6, s.length() - 2);
                    s = in.readLine();
                    des[j] = s.substring(s.length() - 6, s.length() - 2);

                    j++;
                }
            }
            in.close();
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }

        for(int i = 0; i < 60; i++){
            if(Integer.parseInt(des[i].substring(0,1)) == 1) {

            }else if (Integer.parseInt(des[i].substring(0,1)) == 2) {

            }else if (Integer.parseInt(des[i].substring(0,1)) == 3) {

            }else if (Integer.parseInt(des[i].substring(0,1)) == 4) {

            }else {

            }
        }



    }
}
