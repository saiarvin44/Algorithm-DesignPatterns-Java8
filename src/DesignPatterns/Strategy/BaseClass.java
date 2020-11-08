package DesignPatterns.Strategy;

public class BaseClass {
    private IStrategy strategy;

    public BaseClass(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void changeStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.execute();
    }
}
