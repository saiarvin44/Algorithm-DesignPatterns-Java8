package BestPractices.BasicBuilderPatterm;

public class CallBuilderPattern {
  public static void main(String[] args) {
    BuilderPattern cocaCola =
        new BuilderPattern.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
  }
}
