package DesignPatterns.Strategy;

public class App {
    public static void main(String[] args) {
        var baseClass = new BaseClass(new StrategyOne());
        baseClass.execute();
        baseClass.changeStrategy(new StrategyTwo());
        baseClass.execute();
    }
}
