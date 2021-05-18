package DesignPatterns.LowLevelDesign.PizzaDecoratorPattern;

public abstract class BasePizza {
  String description;

  public String getDescription() {
    return this.description;
  }

  public abstract double cost();
}
