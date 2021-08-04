package DesignPatterns.LowLevelDesign.Calculator;

public interface IntermediateResult {
  void calculateIntermediate(String s, StringBuilder builder);
  void postIntermediate(Numbers numbers, Operators operators, Paranthesis paranthesis, StringBuilder builder);

}
