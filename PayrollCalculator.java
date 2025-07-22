public class PayrollCalculator {

    public static void main (String[] args){
        System.out.println(calculateWeeklyPay("FULL_TIME", 55, 30.0));
        System.out.println(calculateTaxDeduction(1500, true));
    }

    public static double calculateWeeklyPay(String employeeType, double hoursWorked, double hourlyRate) {

        double final_pay;
        switch (employeeType.toUpperCase()){
            case "FULL_TIME":
                if (hoursWorked > 40){
                    double overtime_hours = hoursWorked - 40;
                    double overtime_pay = overtime_hours * 1.5;
                    final_pay= overtime_pay + (hourlyRate * 40);
                } else {
                    final_pay = hourlyRate * hoursWorked;
                }
                break;

            case "PART_TIME":
                final_pay = hourlyRate * 25;
                break;

            case "CONTRACTOR":
                final_pay = hourlyRate * hoursWorked;
                break;

            case "INTERN":
                final_pay = hourlyRate * 20 * 0.8;
                break;

            default:
                throw new IllegalArgumentException("Invalid employee type: " + employeeType);
        }
        return final_pay;
    }

    public static double calculateTaxDeduction(double grossPay, boolean hasHealthInsurance){
        double total_tax_amount = 0.0;
        if (grossPay < 501) {
            total_tax_amount = 0.1 * grossPay;
        } else if (grossPay<1001) {
            total_tax_amount = 0.15 * grossPay;
        } else if (grossPay < 2001) {
            total_tax_amount = 0.20 * grossPay;
        } else if (grossPay > 2000) {
            total_tax_amount = 0.25 * grossPay;
        }
        else {
            System.out.println("INVALID INPUT");
        }
        if (hasHealthInsurance) {
            total_tax_amount = total_tax_amount - 50;
        }

        return total_tax_amount;
    }

    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names) {

        String[] final_employeeTypes = {};
        double[] final_hours = {};
        double[] final_rates = {};
        String[] final_names = {};

    }
}
