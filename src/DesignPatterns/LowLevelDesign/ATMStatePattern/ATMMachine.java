package DesignPatterns.LowLevelDesign.ATMStatePattern;

public class ATMMachine implements ATMState {

  ATMState atmState;

  public ATMMachine() {
    this.atmState = new NoDebitCardState();
  }

  public ATMState getAtmState() {
    return atmState;
  }

  public void setAtmState(ATMState atmState) {
    this.atmState = atmState;
  }

  @Override
  public void InsertDebitCard() {
    atmState.InsertDebitCard();
    if (atmState instanceof NoDebitCardState) {
      ATMState hasDebitCardState = new HasDebitCardState();
      setAtmState(hasDebitCardState);
      System.out.println(
          "ATM machine internal state has been moved to : " + atmState.getClass().getName());
    }
  }

  @Override
  public void EjectDebitCard() {
    atmState.EjectDebitCard();
    if (atmState instanceof HasDebitCardState) {
      ATMState noDebitCard = new NoDebitCardState();
      setAtmState(noDebitCard);
      System.out.println(
          "ATM machine internal state has been moved to : " + atmState.getClass().getName());
    }
  }

  @Override
  public void EnterPinAndWithdrawCash() {
    atmState.EnterPinAndWithdrawCash();
  }
}
