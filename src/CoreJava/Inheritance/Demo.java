package CoreJava.Inheritance;

class Child extends Parent {
  static {
    System.out.println("Static Child");
  }

  public void print() {
    System.out.println("Child");
  }
}

class Parent {
  static{
    System.out.println("Static Parent");
  }
  public void print() {
    System.out.println("Parent");
  }
}

public class Demo {
  public static void main(String[] args) {
    Parent p = new Parent();
    Child c = new Child();
    p.print();
    c.print();
    p = c;
    p.print();
  }
}
