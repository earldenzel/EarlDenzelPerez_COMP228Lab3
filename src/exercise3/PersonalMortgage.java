package exercise3;

import java.text.DecimalFormat;

public class PersonalMortgage extends Mortgage {

    public PersonalMortgage(String mortgageNumber, String customerName, double mortgageAmount, double interestRate, int mortgageTerm) {
        super(mortgageNumber, customerName, mortgageAmount, interestRate + PERSONAL_RATE, mortgageTerm);
    }

    @Override
    public String getMortgageInfo() {
        DecimalFormat percent = new DecimalFormat("#%");
        return String.format("%s %s (%s %s)%n",
                "Business",
                super.getMortgageInfo(),
                percent.format(PERSONAL_RATE),
                "above the prime rate");
    }
}
