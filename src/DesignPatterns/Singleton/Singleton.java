package DesignPatterns.Singleton;

public class Singleton {
  private static Singleton instance = null;

  private Singleton() {}

  public static Singleton getInstance() {
    if (instance.equals(null)) instance = new Singleton();
    return instance;
  }
}
