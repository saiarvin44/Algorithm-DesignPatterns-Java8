package DesignPatterns.LowLevelDesign.PizzaDecoratorPattern;

public class MushroomPizza extends BasePizza {
  public MushroomPizza() {
    description = "Mushroom";
  }

  @Override
  public double cost() {
    return 100;
  }
}
