public class PayrollCalculator {

    public static void main (String[] args){
        System.out.println(calculateWeeklyPay("FULL_TIME", 55, 30.0));
        System.out.println(calculateTaxDeduction(1500, true));
        processPayroll(new String[]{"FULL_TIME", "INTERN", "PART_TIME"}, new double[]{50, 20, 29}, new double[]{30, 15, 22}, new String[]{"Mohd", "Ali", "Ahmed"}, new double[]{45, 55, 15});
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

    public static void processPayroll(String[] employeeTypes, double[] hours, double[] rates, String[] names, double[] working_hours) {

        double[] final_pay = new double[names.length];
        double[] final_pay_2 = new double[names.length];

        double highest_pay = 0;
        double lowest_pay = 0;
        double avg_pay = 0;
        double employee_overtime = 0;
        double total_pay = 0.0;

        System.out.println("\n\n === STARTING PAYROLL PROCESS === ");
        for (int i = 0; i < names.length; i++){
            final_pay[i] = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);

            if (working_hours[i] > 40 && employeeTypes[i].equals("FULL_TIME")){
                employee_overtime += 1;

            }

            if (final_pay[i] > highest_pay) {
                highest_pay = final_pay[i];
            }

            if (i == 0) {
                lowest_pay = final_pay[i];
            }

            else if (final_pay[i] < lowest_pay){
                lowest_pay = final_pay[i];
            }
            total_pay += final_pay[i];
        }
        avg_pay = total_pay / names.length;

        for (int i = 0; i < names.length ; i++) {
            final_pay_2[i] = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);

            if (final_pay_2[i] == highest_pay) {
                System.out.println("\nHighest Payed Emp " + names[i] + " with a pay of " + highest_pay);
            } else if (final_pay_2[i] == lowest_pay) {
                System.out.println("\nLowest Payed Emp " + names[i] + " with a pay of " + lowest_pay);
            }
        }
        System.out.println("\nNumber of employees who achived overtime is " + employee_overtime);
        System.out.println("\nAverage Pay is " + avg_pay);
    }
}
