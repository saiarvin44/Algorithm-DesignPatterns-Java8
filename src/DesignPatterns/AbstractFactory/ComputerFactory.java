package DesignPatterns.AbstractFactory;

public interface ComputerFactory {
  Laptop createLaptop();

  Server createServer();
}
