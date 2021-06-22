package CoreJava.Generics;

public class Output3 {
  public void print(String str) {
    System.out.println("String " + str);
  }

  public void print(Integer i) {
    System.out.println("Integer " + i);
  }

  public <T> void print(T t) {
    print(t);
  }
}

class Main {
  public static void main(String[] args) {
    Output3 o = new Output3();
    o.print(new Integer(5));
  }
}
