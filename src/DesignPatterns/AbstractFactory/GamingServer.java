package DesignPatterns.AbstractFactory;

public class GamingServer implements Server {
  @Override
  public void runPingTest() {
    System.out.println("Running ping test on gaming server");
  }
}
