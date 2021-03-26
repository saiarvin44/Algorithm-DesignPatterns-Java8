package BestPractices.EnumSingletonPattern;

public class SingletonTest {
  public static void main(String[] args) {
    Singleton.INSTANCE.setCount(1);
    Singleton.INSTANCE.setCount(2);
    Singleton.INSTANCE.doProcess();
    Singleton.INSTANCE.doProcess();
    Singleton.INSTANCE.doProcess();
  }
}
