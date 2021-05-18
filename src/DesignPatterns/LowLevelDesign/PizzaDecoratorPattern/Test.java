package DesignPatterns.LowLevelDesign.PizzaDecoratorPattern;

public class Test {
  public static void main(String[] args) {
    BasePizza pizza = new CheeseToppings(new CheeseCrust(new PaneerPizza()));
    System.out.println(pizza.getDescription() + " costs " + pizza.cost());
  }
}
