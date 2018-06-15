package exercise3;

/*
* CityToronto bank provides mortgages for individuals and businesses up to $300,000.
* Write a Java application that keeps track of mortgages and computes the total amount
* owed at any time (mortgage amount + interest).
*
* Design the following classes to implement your application:
*
* Mortgage – an abstract class that implements the MortgageConstants interface.
* A Mortgage includes a mortgage number, customer name, amount of mortgage, interest rate, and term.
*
* Don’t allow mortgage amounts over $300,000.
* Force any mortgage term that is not defined in the MortgageConstants interface to a short-term, one year loan.
* Create a getMortgageInfo method to display all the mortgage data.
*
* MortgageConstants – includes constant values for short-term (one year), medium-term (three years)
* and long-term (5 years) mortgages. It also contains constants for bank name and the maximum mortgage amount.
*
* BusinessMortgage – extends Mortgage. Its constructor sets the interest rate to 1% over the current prime rate.
* PersonalMortgage - extends Mortgage. Its constructor sets the interest rate to 2% over the current prime rate.
* ProcessMortgage – a main class that create an array of 3 mortgages. Prompt the user for the current interest rate.
* Then in a loop prompts the user for a mortgage type and all relevant information for that mortgage.
* Store the created Mortgage objects in the array. When data entry is complete, display all mortgages.
*/

import java.text.DecimalFormat;

abstract class Mortgage  implements MortgageConstants{

    private final String mortgageNumber;
    private final String customerName;
    private double mortgageAmount;
    private double interestRate;
    private int mortgageTerm;

    //constructor
    public Mortgage(String mortgageNumber, String customerName, double mortgageAmount, double interestRate, int mortgageTerm) {
        checkValidMortgageAmount (mortgageAmount);
        checkValidInterestRate (interestRate);

        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.mortgageTerm = checkCorrectMortgageTerm(mortgageTerm);
        this.interestRate = interestRate;
        this.mortgageAmount = mortgageAmount;
    }

    public String getMortgageInfo(){
        DecimalFormat percent = new DecimalFormat("#%");
        return String.format("Mortgage%n%s: %s%n%s: %s%n%s: %s%n%s: $%.2f%n%s: %d %s%n%s: %s",
                "Policy Number", getMortgageNumber(),
                "Customer Name", getCustomerName(),
                "Bank", BANK_NAME,
                "Mortgage Amount", getMortgageAmount(),
                "Term", getMortgageTerm(), "years",
                "Interest Rate", percent.format(getInterestRate()));
    }

    //checkers
    private static void checkValidMortgageAmount(double amount){
        if (amount < 0 || amount > MAXIMUM_MORTGAGE){
            throw new IllegalArgumentException ("Mortgage amount must be between $0-$300,000");
        }
    }

    private static void checkValidInterestRate(double rate){
        if (rate < 0){
            throw new IllegalArgumentException ("Interest rate must be 0% or greater");
        }
    }

    private static int checkCorrectMortgageTerm(int term){
        switch (term){
            case SHORT_TERM:
            case MEDIUM_TERM:
            case LONG_TERM:
                return term;
            default:
                return SHORT_TERM;
        }
    }

    //getters
    public String getMortgageNumber() {
        return mortgageNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getMortgageAmount() {
        return mortgageAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getMortgageTerm() {
        return mortgageTerm;
    }

    //setters
    public void setMortgageAmount(double mortgageAmount) {
        checkValidMortgageAmount(mortgageAmount);
        this.mortgageAmount = mortgageAmount;
    }

    public void setInterestRate(double interestRate) {
        checkValidInterestRate(interestRate);
        this.interestRate = interestRate;
    }

    public void setMortgageTerm(int mortgageTerm) {
        this.mortgageTerm = checkCorrectMortgageTerm(mortgageTerm);
    }
}
