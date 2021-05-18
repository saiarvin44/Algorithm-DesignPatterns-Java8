package DesignPatterns.LowLevelDesign.PizzaDecoratorPattern;

public class CheeseCrust extends CrustDecorator {
  BasePizza pizza;

  public CheeseCrust(BasePizza pizza) {
    this.pizza = pizza;
  }

  @Override
  public String getDescription() {
    return pizza.getDescription() + " With Cheese Crust";
  }

  @Override
  public double cost() {
    return pizza.cost() + 50;
  }
}
