package BestPractices.BuilderPatternForHeirarchy;

import static BestPractices.BuilderPatternForHeirarchy.NyPizzaBuilder.Size.SMALL;
import static BestPractices.BuilderPatternForHeirarchy.PizzaBuilder.Topping.ONION;
import static BestPractices.BuilderPatternForHeirarchy.PizzaBuilder.Topping.SAUSAGE;

public class CallPizzaBuilder {
  public static void main(String[] args) {
    NyPizzaBuilder pizza =
        new NyPizzaBuilder.Builder(SMALL).addTopping(SAUSAGE).addTopping(ONION).build();
  }
}
