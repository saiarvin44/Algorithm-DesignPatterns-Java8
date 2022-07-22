package Interviews.taxCalculator;


public class NewTax60Below implements Tax {
    private double tax = 0;

    @Override
    public double calculateTax(double income) {
        if (income <= 250000) {
            tax = 0;
            return tax;
        } else if (income <= 500000) {
            tax = 0.05 * (income - 250000);
            return tax;
        } else if (income <= 750000) {
            tax = 12500 + 0.1 * (income - 500000);
            return tax;
        } else if (income <= 1000000) {
            tax = 37500 + 0.15 * (income - 750000);
            return tax;
        } else if (income <= 1250000) {
            tax = 75000 + 0.20 * (income - 1000000);
            return tax;
        } else if (income <= 1500000) {
            tax = 125000 + 0.25 * (income - 1250000);
            return tax;
        } else {
            tax = 187500 + 0.3 * (income - 1500000);
            return tax;
        }
    }
}
