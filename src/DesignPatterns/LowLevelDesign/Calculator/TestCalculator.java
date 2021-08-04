package DesignPatterns.LowLevelDesign.Calculator;

public class TestCalculator {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    calculator.calculate("1");
    calculator.calculate("+");
    calculator.calculate("2");
    calculator.calculate("-");
    calculator.calculate("(");
    calculator.calculate("1");
    calculator.calculate("+");
    calculator.calculate("2");
    calculator.calculate(")");
    calculator.calculate("=");

  }


}
