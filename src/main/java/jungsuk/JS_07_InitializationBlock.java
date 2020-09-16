package jungsuk;

/**
 * Created by minho on 2017-06-15.
 */
public class JS_07_InitializationBlock {
    static int i = 0;
    //class initialization block - 클래스가 메모리에 처음 로딩될 때 한번만 수행된다.
    static {
        System.out.println("JS_07_InitializationBlock.class has been started");
    }
    //instance initialization block - 생성자와 같이 인스턴스를 생성할 때 마다 수행된다.
    {
        System.out.println("Instance of JS_07_LintializationBlock has been called :)");
        i++;
        System.out.println("number of " + i + " called");
    }
    public static void main(String[] args) {
        System.out.println("main method has been started");

        new JS_07_InitializationBlock();
        new JS_07_InitializationBlock();
        new JS_07_InitializationBlock();
    }
}
