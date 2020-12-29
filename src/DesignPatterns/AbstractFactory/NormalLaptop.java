package DesignPatterns.AbstractFactory;

public class NormalLaptop implements Laptop {
  @Override
  public void runTests() {
    System.out.println("Running tests on normalLaptop...");
  }
}
