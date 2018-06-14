package exercise3;

import java.text.DecimalFormat;

public class BusinessMortgage extends Mortgage {

    public BusinessMortgage(String mortgageNumber, String customerName, double mortgageAmount, double interestRate, int mortgageTerm) {
        super(mortgageNumber, customerName, mortgageAmount, interestRate + BUSINESS_RATE, mortgageTerm);
    }

    @Override
    public String getMortgageInfo() {
        DecimalFormat percent = new DecimalFormat("#%");
        return String.format("%s %s (%s %s)%n",
                "Business",
                super.getMortgageInfo(),
                percent.format(BUSINESS_RATE),
                "above the prime rate");
    }
}
