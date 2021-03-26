package BestPractices.BuilderPatternForHeirarchy;

import java.util.Objects;

public class NyPizzaBuilder extends PizzaBuilder {

  private final Size size;

  private NyPizzaBuilder(Builder builder) {

    super(builder);

    size = builder.size;
  }

  public enum Size {
    SMALL,
    MEDIUM,
    LARGE
  }

  public static class Builder extends PizzaBuilder.Builder<Builder> {

    private final Size size;

    public Builder(Size size) {

      this.size = Objects.requireNonNull(size);
    }

    @Override
    public NyPizzaBuilder build() {

      return new NyPizzaBuilder(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
