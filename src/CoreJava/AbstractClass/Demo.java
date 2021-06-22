package CoreJava.AbstractClass;

public abstract class Demo {
  public abstract void print();

  public void callPrint() {
    print();
  }
}

class Main extends Demo {

  @Override
  public void print() {
    System.out.println("Child class");
  }
}

class Test {
  public static void main(String[] args) {
    Demo d = new Main();
    d.callPrint();
  }
}
