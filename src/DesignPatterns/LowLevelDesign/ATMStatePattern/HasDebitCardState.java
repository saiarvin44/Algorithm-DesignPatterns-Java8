package DesignPatterns.LowLevelDesign.ATMStatePattern;

public class HasDebitCardState implements ATMState {
  @Override
  public void InsertDebitCard() {
    System.out.println("You cant insert debit card");
  }

  @Override
  public void EjectDebitCard() {
    System.out.println("Debit card ejected");
  }

  @Override
  public void EnterPinAndWithdrawCash() {
    System.out.println("Okay Take cash");
  }
}
