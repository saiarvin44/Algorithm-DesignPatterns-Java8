package Interviews.taxCalculator;

public class OldTax60Below implements Tax {
    private double tax = 0;

    @Override
    public double calculateTax(double income) {
        if (income <= 250000) {
            tax = 0;
            return tax;
        } else if (income <= 500000) {
            tax = 0.05 * (income - 250000);
            return tax;
        } else if (income <= 1000000) {
            tax = 12500 + 0.2 * (income - 500000);
            return tax;
        } else {
            tax = 112500 + 0.3 * (income - 1000000);
            return tax;
        }
    }
}
