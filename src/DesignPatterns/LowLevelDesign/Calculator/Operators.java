package DesignPatterns.LowLevelDesign.Calculator;

import static DesignPatterns.LowLevelDesign.Calculator.Constants.commonIsNumber;

public class Operators implements IntermediateResult {

  private boolean enableOperators, operatorIdentified;

  public boolean isEnableOperators() {
    return enableOperators;
  }

  public void setEnableOperators(boolean enableOperators) {
    this.enableOperators = enableOperators;
  }

  @Override
  public void calculateIntermediate(String s, StringBuilder builder) {
    if (checkOperators(builder)) {
      operatorIdentified = true;
      builder.append(s);
      System.out.println("Enter next ... ");
      return;
    }
    operatorIdentified = false;
    System.out.println("Operation not supported sorry!");
  }

  private boolean checkOperators(StringBuilder builder) {
    if (commonIsNumber(builder) && this.isEnableOperators()) return true;
    return false;
  }

  @Override
  public void postIntermediate(Numbers numbers, Operators operators, Paranthesis paranthesis, StringBuilder builder) {
    if (operatorIdentified) {
      paranthesis.setEnableRightP(false);
      paranthesis.setEnableLeftP(true);
      numbers.setEnableNumber(true);
      operators.setEnableOperators(false);
    }
  }
}
