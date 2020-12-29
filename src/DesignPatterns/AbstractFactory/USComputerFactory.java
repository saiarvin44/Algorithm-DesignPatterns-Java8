package DesignPatterns.AbstractFactory;

public class USComputerFactory implements ComputerFactory {
  @Override
  public Laptop createLaptop() {
    return new NormalLaptop();
  }

  @Override
  public Server createServer() {
    return new NormalServer();
  }
}
