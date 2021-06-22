package DesignPatterns.Strategy;

public class App {
  public static void main(String[] args) {
    BaseClass baseClass = new BaseClass(new StrategyOne());
    baseClass.execute();
    baseClass.changeStrategy(new StrategyTwo());
    baseClass.execute();
  }
}
