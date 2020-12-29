package DesignPatterns.AbstractFactory;

public class PolandComputerFactory implements ComputerFactory {
  @Override
  public Laptop createLaptop() {
    return new GamingLaptop();
  }

  @Override
  public Server createServer() {
    return new GamingServer();
  }
}
