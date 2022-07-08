package CoreJava.Static;

public class Example2 {
    static int a;

    static void method1() {
        a = 5;
    }

    public static void main(String[] args) {
        a = 6;
        method1();
        System.out.println(a);
    }
}
