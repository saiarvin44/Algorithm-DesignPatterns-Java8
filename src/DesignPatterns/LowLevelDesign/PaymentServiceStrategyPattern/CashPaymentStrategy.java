package DesignPatterns.LowLevelDesign.PaymentServiceStrategyPattern;

public class CashPaymentStrategy implements PaymentStrategy {
  @Override
  public void pay(String amount) {
    System.out.print("Paying " + amount + " using Cash");
  }
}
