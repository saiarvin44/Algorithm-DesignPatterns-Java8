package DesignPatterns.LowLevelDesign.PaymentServiceStrategyPattern;

public class CreditCardPaymentStrategy implements PaymentStrategy {
  @Override
  public void pay(String amount) {
    System.out.print("Paying " + amount + " using Credit Card");
  }
}
