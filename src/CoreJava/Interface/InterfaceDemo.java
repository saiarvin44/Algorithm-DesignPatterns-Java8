package CoreJava.Interface;

public class InterfaceDemo {
  public static void main(String[] args) {
    I i = new B();
    A a = new B();
    a.m1();
    B b = (B) new A();
    b.m1();
  }
}
