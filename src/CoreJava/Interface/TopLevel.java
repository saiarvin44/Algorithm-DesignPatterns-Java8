package CoreJava.Interface;

public interface TopLevel {
  void methodA();
}

class LowLevel implements TopLevel {
  @Override
  public void methodA() {
    System.out.println("Low Level implementing Top Level called!");
  }
}

class LowestLevel implements TopLevel {
  @Override
  public void methodA() {
    System.out.println("Lowest Level implementing Top Level called!");
  }
}

class Demo {
  public static void main(String[] args) {
    TopLevel l1 = new LowLevel();
    TopLevel l2 = new LowestLevel();
    System.out.print("Low level equals LowestLevel ? " + l1.equals(l2));
  }
}
