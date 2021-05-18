package DesignPatterns.LowLevelDesign.PizzaDecoratorPattern;

public class OreganoToppings extends ToppingsDecorator {
  BasePizza pizzaWithCrust;

  public OreganoToppings(BasePizza pizzaWithCrust) {
    this.pizzaWithCrust = pizzaWithCrust;
  }

  @Override
  public String getDescription() {
    return pizzaWithCrust.getDescription() + " with Oregano Topping";
  }

  @Override
  public double cost() {
    return pizzaWithCrust.cost() + 10;
  }
}
