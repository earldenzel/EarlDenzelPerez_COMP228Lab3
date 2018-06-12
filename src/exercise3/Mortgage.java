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

abstract class Mortgage {
    private static final int SHORT_TERM = 1;
    private static final int MEDIUM_TERM = 3;
    private static final int LONG_TERM = 5;

    private final String mortgageNumber;
    private final String customerName;
    private double mortgageAmount;
    private double interestRate;
    private int mortgageTerm;

    //constructor
    public Mortgage(String mortgageNumber, String customerName, double mortgageAmount, double interestRate, int mortgageTerm) {
        checkValidMortgageAmount (mortgageAmount);

        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.mortgageTerm = checkCorrectMortgageTerm(mortgageTerm);
        this.interestRate = interestRate;
        this.mortgageTerm = mortgageTerm;
    }

    //abstract methods
    public abstract String getMortgageInfo();

    //checkers
    private static void checkValidMortgageAmount(double amount){
        if (amount < 0 || amount > 300000){
            throw new IllegalArgumentException ("Mortgage amount must be between $0-$300,000");
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
        this.interestRate = interestRate;
    }

    public void setMortgageTerm(int mortgageTerm) {
        this.mortgageTerm = checkCorrectMortgageTerm(mortgageTerm);
    }
}
