package DesignPatterns.LowLevelDesign.Calculator;

import static DesignPatterns.LowLevelDesign.Calculator.Constants.*;

public class Numbers implements IntermediateResult {
  private boolean enableNumber;
  private boolean numberIdentified;

  public boolean isEnableNumber() {
    return enableNumber;
  }

  public void setEnableNumber(boolean enableNumber) {
    this.enableNumber = enableNumber;
  }

  private boolean checkValidNumber(StringBuilder builder) {
    String curr = builder.toString();
    char lastChar = curr.charAt(curr.length() - 1);
    if ((curr.isEmpty() || lastChar == '(' || lastChar == add || lastChar == subtract || lastChar == multiply || lastChar == divide || (curr.length() == 1 && commonIsNumber(builder))) && this.isEnableNumber())
      return true;
    return false;
  }

  @Override
  public void calculateIntermediate(String s, StringBuilder builder) {
    if (builder.toString().isEmpty()) {
      numberIdentified=true;
      builder.append(s);
      return;
    }
    if (checkValidNumber(builder)) {
      builder.append(s);
      numberIdentified=true;
      System.out.println("Enter next ... ");
      return;
    }
    numberIdentified=false;
    System.out.println("Operation not supported sorry!");
  }

  @Override
  public void postIntermediate(Numbers numbers, Operators operators, Paranthesis paranthesis, StringBuilder builder) {
    if (numberIdentified) {
      if (commonIsEnableRightP(builder)) paranthesis.setEnableRightP(true);
      else paranthesis.setEnableRightP(false);
      paranthesis.setEnableLeftP(false);
      numbers.setEnableNumber(true);
      operators.setEnableOperators(true);
    }
  }
}
