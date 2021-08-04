package DesignPatterns.LowLevelDesign.Calculator;

import java.util.regex.Pattern;

import static DesignPatterns.LowLevelDesign.Calculator.Constants.*;

public class Calculator {
  private StringBuilder builder;
  private Numbers number;
  private Operators operator;
  private Paranthesis paranthesis;
  boolean isNumber = false, isLeftP = false, isRightP = false, isOperator = false, isEqualTo = false;
  private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

  public Calculator() {
    builder = new StringBuilder();
    number = new Numbers();
    operator = new Operators();
    paranthesis = new Paranthesis();
    initialSetUp();
  }

  private void initialSetUp() {
    number.setEnableNumber(true);
    operator.setEnableOperators(false);
    paranthesis.setEnableRightP(false);
    paranthesis.setEnableLeftP(true);
  }


  public void calculate(String s) {
    findOutType(s);
    if (isNumber) {
      number.calculateIntermediate(s, builder);
      number.postIntermediate(number, operator, paranthesis, builder);
    } else if (isLeftP || isRightP) {
      paranthesis.calculateIntermediate(s, builder);
      paranthesis.postIntermediate(number, operator, paranthesis, builder);
    } else if (isOperator) {
      operator.calculateIntermediate(s, builder);
      operator.postIntermediate(number, operator, paranthesis, builder);
    } else if (isEqualTo) {
      System.out.println("Your result = " + builder.toString());
    }
    isNumber = false;
    isLeftP = false;
    isRightP = false;
    isOperator = false;
  }


  private void findOutType(String s) {
    isNumber = pattern.matcher(s).matches();
    if (s.charAt(0) == leftP) isLeftP = true;
    if (s.charAt(0) == rightP) isRightP = true;
    if (s.charAt(0) == add || s.charAt(0) == subtract || s.charAt(0) == multiply || s.charAt(0) == divide)
      isOperator = true;
    if (s.charAt(0) == equalTo) isEqualTo = true;
  }


}
