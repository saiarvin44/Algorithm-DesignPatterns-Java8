package DesignPatterns.LowLevelDesign.ATMStatePattern;

public class NoDebitCardState implements ATMState {
  @Override
  public void InsertDebitCard() {
    System.out.println("Debit card inserted");
  }

  @Override
  public void EjectDebitCard() {
    System.out.println("You cant eject debit card");
  }

  @Override
  public void EnterPinAndWithdrawCash() {
    System.out.println("You cant withdraw cash");
  }
}
