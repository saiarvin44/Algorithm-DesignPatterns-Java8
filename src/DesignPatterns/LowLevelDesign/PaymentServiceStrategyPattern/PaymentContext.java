package DesignPatterns.LowLevelDesign.PaymentServiceStrategyPattern;

public class PaymentContext {
  private PaymentStrategy paymentStrategy;

  public PaymentStrategy getPaymentStrategy() {
    return paymentStrategy;
  }

  public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = paymentStrategy;
  }

  public void pay(String amount) {
    paymentStrategy.pay(amount);
  }
}
