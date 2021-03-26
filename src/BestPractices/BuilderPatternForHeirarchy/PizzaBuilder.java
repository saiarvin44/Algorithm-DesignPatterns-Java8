package BestPractices.BuilderPatternForHeirarchy;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class PizzaBuilder {

  final Set<Topping> toppings;

  PizzaBuilder(Builder<?> builder) {

    toppings = builder.toppings.clone(); // See Item  50
  }

  public enum Topping {
    HAM,
    MUSHROOM,
    ONION,
    PEPPER,
    SAUSAGE
  }

  abstract static class Builder<T extends Builder<T>> {

    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

    public T addTopping(Topping topping) {

      toppings.add(Objects.requireNonNull(topping));

      return self();
    }

    abstract PizzaBuilder build();

    // Subclasses must override this method to return "this"

    protected abstract T self();
  }
}
