package Interviews.taxCalculator;

import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        Tax tax = null;
        String age, regime, income;
        Scanner s = new Scanner(System.in);
        age = s.nextLine();
        regime = s.nextLine();
        income = s.nextLine();

        if (Integer.parseInt(age) < 60 && regime.equalsIgnoreCase("old")) tax = new OldTax60Below();
        else if (Integer.parseInt(age) < 60 && regime.equalsIgnoreCase("new")) tax = new NewTax60Below();

        System.out.println(tax.calculateTax(Double.parseDouble(income)));
    }
}
