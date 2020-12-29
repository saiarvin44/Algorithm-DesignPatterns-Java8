package DesignPatterns.AbstractFactory;

public class NormalServer implements Server {
  @Override
  public void runPingTest() {
    System.out.println("Running ping test on normal server...");
  }
}
