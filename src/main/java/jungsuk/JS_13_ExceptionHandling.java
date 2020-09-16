package jungsuk;

/**
 * Created by minho on 2017-06-19.
 */

import java.io.File;
import java.io.IOException;

/**
 * Error - 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
 *  ex) OutOfMemoryError, StackOverFlow
 *
 * Exception - 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류
 *  1. RuntimeException 클래스와 그 자손 클래스들 : 프로그래머의 실수로 발생하는 예외
 *   ex) ArithmaticException, ClassCastException, NullPointException, IndexOutOfBoundsException
 *  2. Exception클래스와 그 자손 클래스들 : 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외
 *   ex) IOException, ClassNotFoundException
 *
 *
 *  Exception Handling
 *      - 정의 : 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한 코드를 작성
 *      - 목적 : 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것
 */
public class JS_13_ExceptionHandling {
    public static void main(String[] args) {
        try {
            File f = createFile("HelloWorld.java");
            System.out.println(f.getName() + "파일이 성공적으로 생성되었습니다.");
        } catch(Exception e) {
            System.out.println(e.getMessage() + " 다시 입력해 주시기 바랍니다.");
        }
        try {
            File f = createFile("");
            System.out.println(f.getName() + "파일이 성공적으로 생성되었습니다.");
        } catch(Exception e) {
            System.out.println(e.getMessage() + " 다시 입력해 주시기 바랍니다.");
        }
        try_catch();
    }

    //1. 기본적인 try-catch 문 이해
    static void try_catch() {
        try {
            try{} catch(Exception e) {}
        }catch (Exception ae) {
            try {} catch(Exception error) {} //error. 'e' 변수가 중복 선언되었다.
        }//try-catch의 끝

        System.out.println(-1);
        System.out.println(0);
        try {
            System.out.println("Try area has been activated.");
            System.out.println(1);
            System.out.println(2);
            System.out.println(3/0);
            System.out.println(4);
        }catch (ArithmeticException ae) {
            //ae 발생시 실행
//            if(ae instanceof ArithmeticException) {
//                System.out.println("true");
//            } // 무슨차이일까나
            System.out.println("Catch area has been activated.");
            ae.printStackTrace(); //에외발생 당시의 call stack에 있었던 메서드의 정보와 예외 메시지 출력
           ae.getMessage(); // 발생한 예외클래스의 인스턴스에 저장된 메시지.
        }catch (Exception e) {
            //ae 이외 exception 발생시 실행
            System.out.println(e);
        }finally {
            System.out.println("finally area has been activated");
        }//try-catch의 끝

        System.out.println("This is not try-catch area");

    }

    //메서드에 예외 선언하기.
    static File createFile(String fileName) throws Exception {
        if(fileName == null || fileName.equals("")) {
            throw new Exception("파일이름이 유효하지 않습니다.");
        }
        File f = new File(fileName);

        f.createNewFile();

        return f;
    }
}
