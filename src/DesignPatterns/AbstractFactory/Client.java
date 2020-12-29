package DesignPatterns.AbstractFactory;

public class Client {
  public static void main(String[] args) {
    ComputerFactory factory = new PolandComputerFactory();
    Server server = factory.createServer();
    server.runPingTest();
  }
}
