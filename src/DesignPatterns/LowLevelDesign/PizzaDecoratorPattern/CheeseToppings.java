package DesignPatterns.LowLevelDesign.PizzaDecoratorPattern;

public class CheeseToppings extends ToppingsDecorator {
  BasePizza pizzaWithCrust;

  public CheeseToppings(BasePizza pizzaWithCrust) {
    this.pizzaWithCrust = pizzaWithCrust;
  }

  @Override
  public String getDescription() {
    return pizzaWithCrust.getDescription() + " With Cheese Topping";
  }

  @Override
  public double cost() {
    return pizzaWithCrust.cost() + 10;
  }
}
