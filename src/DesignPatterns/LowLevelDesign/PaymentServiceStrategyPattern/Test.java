package DesignPatterns.LowLevelDesign.PaymentServiceStrategyPattern;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    System.out.println("Enter payment Type : 'CreditCard' or 'DebitCard' or 'Cash'");
    Scanner scanner = new Scanner(System.in);
    String paymentType = scanner.next();
    System.out.println("Enter amount to pay : ");
    String amount = scanner.next();
    PaymentContext ctx = new PaymentContext();
    switch (paymentType) {
      case "CreditCard":
        ctx.setPaymentStrategy(new CreditCardPaymentStrategy());
        break;
      case "DebitCard":
        ctx.setPaymentStrategy(new DebitCardPaymentStrategy());
        break;
      case "Cash":
      default:
        ctx.setPaymentStrategy(new CashPaymentStrategy());
    }

    ctx.pay(amount);
  }
}
