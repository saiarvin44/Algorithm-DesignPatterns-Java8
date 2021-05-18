package DesignPatterns.LowLevelDesign.ATMStatePattern;

public class Test {
  public static void main(String[] args) {
    ATMMachine atmMachine = new ATMMachine();
    System.out.println(
        "ATM machine current state : " + atmMachine.getAtmState().getClass().getName());
    atmMachine.EnterPinAndWithdrawCash();
    atmMachine.EjectDebitCard();
    atmMachine.InsertDebitCard();

    System.out.println(
        "ATM machine current state : " + atmMachine.getAtmState().getClass().getName());
    atmMachine.InsertDebitCard();
    atmMachine.EnterPinAndWithdrawCash();
    atmMachine.EjectDebitCard();
  }
}
