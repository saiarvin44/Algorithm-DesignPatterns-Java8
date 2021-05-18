package DesignPatterns.LowLevelDesign.PizzaDecoratorPattern;

public class TomatoPizza extends BasePizza {
  public TomatoPizza() {
    description = "Tomato Pizza";
  }

  @Override
  public double cost() {
    return 80;
  }
}
