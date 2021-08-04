package DesignPatterns.LowLevelDesign.Calculator;


import static DesignPatterns.LowLevelDesign.Calculator.Constants.*;
import static DesignPatterns.LowLevelDesign.Calculator.Constants.divide;

public class Paranthesis implements IntermediateResult {

  private boolean enableLeftP;
  private boolean enableRightP;
  private boolean leftPIdentified, rightPIdentified;


  public boolean isEnableLeftP() {
    return enableLeftP;
  }

  public void setEnableLeftP(boolean enableLeftP) {
    this.enableLeftP = enableLeftP;
  }

  public boolean isEnableRightP() {
    return enableRightP;
  }

  public void setEnableRightP(boolean enableRightP) {
    this.enableRightP = enableRightP;
  }

  private boolean checkLeftP(StringBuilder builder) {
    String curr = builder.toString();
    char lastChar = curr.charAt(curr.length() - 1);
    if ((curr.isEmpty() || lastChar == leftP || lastChar == add || lastChar == subtract || lastChar == multiply || lastChar == divide) && this.isEnableLeftP())
      return true;
    return false;
  }

  private boolean checkRightP(StringBuilder builder) {
    if (commonIsEnableRightP(builder) && this.isEnableRightP())
      return true;
    return false;
  }

  @Override
  public void calculateIntermediate(String s, StringBuilder builder) {
    if (checkLeftP(builder)) {
      leftPIdentified = true;
      rightPIdentified = false;
      builder.append(s);
      System.out.println("Enter next ... ");
      return;
    } else if (checkRightP(builder)) {
      leftPIdentified = false;
      rightPIdentified = true;
      builder.append(s);
      System.out.println("Enter next ... ");
      return;
    }
    leftPIdentified = false;
    rightPIdentified = false;
    System.out.println("Operation not supported sorry!");
  }

  @Override
  public void postIntermediate(Numbers numbers, Operators operators, Paranthesis paranthesis, StringBuilder builder) {
    if (leftPIdentified) {
      if (commonIsEnableRightP(builder)) paranthesis.setEnableRightP(true);
      else paranthesis.setEnableRightP(false);
      paranthesis.setEnableLeftP(true);
      numbers.setEnableNumber(true);
      operators.setEnableOperators(false);
    } else if (rightPIdentified) {
      if (commonIsEnableRightP(builder)) paranthesis.setEnableRightP(true);
      else paranthesis.setEnableRightP(false);
      paranthesis.setEnableLeftP(false);
      numbers.setEnableNumber(false);
      operators.setEnableOperators(true);
    }
  }
}
