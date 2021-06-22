package CoreJava.Interface;

public class Test1 {

  public static void main(String[] args) {
    classB b = new classB();
    System.out.print(b instanceof classC);
  }
}

class classA {}

class classB extends classA {}

class classC extends classB {}
