package DesignPatterns.LowLevelDesign.PaymentServiceStrategyPattern;

public class DebitCardPaymentStrategy implements PaymentStrategy {
  @Override
  public void pay(String amount) {
    System.out.print("Paying " + amount + " using Debit Card");
  }
}
