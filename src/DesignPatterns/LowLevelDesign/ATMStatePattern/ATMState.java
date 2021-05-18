package DesignPatterns.LowLevelDesign.ATMStatePattern;

public interface ATMState {
  void InsertDebitCard();

  void EjectDebitCard();

  void EnterPinAndWithdrawCash();
}
