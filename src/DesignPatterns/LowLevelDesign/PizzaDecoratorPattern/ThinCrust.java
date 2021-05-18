package DesignPatterns.LowLevelDesign.PizzaDecoratorPattern;

public class ThinCrust extends CrustDecorator {
  BasePizza pizza;

  public ThinCrust(BasePizza pizza) {
    this.pizza = pizza;
  }

  @Override
  public String getDescription() {
    return pizza.getDescription() + " With Thin Crust";
  }

  @Override
  public double cost() {
    return pizza.cost() + 40;
  }
}
