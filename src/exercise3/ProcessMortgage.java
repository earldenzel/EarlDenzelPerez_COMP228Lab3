package exercise3;

import javax.swing.*;

public class ProcessMortgage {
    public static void main(String[] args) {
        Mortgage[] mortgages = new Mortgage[3];
        boolean askInterestAgain = true;
        double primeRate = 0;

        //forcing user to input correct interest amount
        while (askInterestAgain) {
            try {
                primeRate = Double.parseDouble(JOptionPane.showInputDialog("Input current prime rate in %")) / 100;
                askInterestAgain = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Your prime rate should be a number. You will be asked again");
                askInterestAgain = true;
            }

            if (primeRate < 0){
                JOptionPane.showMessageDialog(null, "Your prime rate should be greater than 0. You will be asked again");
                askInterestAgain = true;
            }
        }

        for (int i = 0; i < mortgages.length; i++){
            boolean validMortgage = false;
            Mortgage mortgage;
            String[] buttons = { "Business Mortgage", "Personal Mortgage"};

            //ask user for mortgage details until valid details are provided
            while (!validMortgage){
                String policyNumber = JOptionPane.showInputDialog("Please input policy number for application #" + (i+1));
                String customerName = JOptionPane.showInputDialog("Enter customer name");
                int rc = JOptionPane.showOptionDialog(
                        null,
                        "What type of mortgage will you get?",
                        "Mortgage Type", JOptionPane.DEFAULT_OPTION, 3, null, buttons, buttons[1]);
                int mortgageTerm = Integer.parseInt(JOptionPane.showInputDialog("Enter term length in years"));
                double mortgageAmount = Double.parseDouble(JOptionPane.showInputDialog("Input mortgage value"));

                switch (rc){
                    case 0:
                        try{
                            mortgage = new BusinessMortgage(policyNumber,customerName,mortgageAmount,primeRate,mortgageTerm);
                            validMortgage = true;
                            mortgages[i] = mortgage;
                            JOptionPane.showMessageDialog(null, "New business mortgage added!");
                        }
                        catch (Exception e){
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        break;
                    case 1:
                        try{
                            mortgage = new PersonalMortgage(policyNumber,customerName,mortgageAmount,primeRate,mortgageTerm);
                            validMortgage = true;
                            mortgages[i] = mortgage;
                            JOptionPane.showMessageDialog(null, "New personal mortgage added!");
                        }
                        catch (Exception e){
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        //show all added mortgages
        String message = "";
        for (Mortgage mort: mortgages){
            message += String.format("%s%n%n", mort.getMortgageInfo());
        }
        JOptionPane.showMessageDialog(null,message);
    }
}
