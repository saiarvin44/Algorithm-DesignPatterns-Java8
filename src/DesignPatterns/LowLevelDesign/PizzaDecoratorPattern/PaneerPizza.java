package DesignPatterns.LowLevelDesign.PizzaDecoratorPattern;

public class PaneerPizza extends BasePizza {
  public PaneerPizza() {
    description = "Paneer Pizza";
  }

  @Override
  public double cost() {
    return 120;
  }
}
