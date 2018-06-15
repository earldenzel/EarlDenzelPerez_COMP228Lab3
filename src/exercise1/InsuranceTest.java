package exercise1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//driver class
public class InsuranceTest {
    public static void main(String[] args) {
        Insurance[] insurances; //exercise requires array, not array list
        List<Insurance> insuranceList = new ArrayList<Insurance>(); //we're using lists to make it easy to code

        String[] buttons = { "Health Insurance", "Life Insurance", "Done adding"};
        int rc = 0;
        String insuranceType;
        double insuranceCost;

        //add insurance objects until user gets bored of the process and quits
        while (rc != 2){
            rc = JOptionPane.showOptionDialog(
                    null,
                    "What type of insurance are you processing?",
                    "Enter Type", JOptionPane.DEFAULT_OPTION, 3, null, buttons, buttons[2]);

            switch (rc){
                case 0: //health insurance
                    insuranceType = JOptionPane.showInputDialog("Please enter health insurance type");
                    insuranceCost = Double.parseDouble(JOptionPane.showInputDialog("Please enter the monthly fee for " + insuranceType));
                    try {
                        insuranceList.add(new HealthInsurance(insuranceType, insuranceCost));
                    }
                    catch (Exception e){
                        insuranceList.add(new HealthInsurance(insuranceType, 0));
                        JOptionPane.showMessageDialog(null, String.format("%s%n%s", e.getMessage(), "Cost temporarily set to $0"));
                    }
                    JOptionPane.showMessageDialog(null,"Health insurance added to list");
                    break;
                case 1: //life insurance
                    insuranceType = JOptionPane.showInputDialog("Please enter life insurance type");
                    insuranceCost = Double.parseDouble(JOptionPane.showInputDialog("Please enter monthly fee for " + insuranceType));
                    try {
                        insuranceList.add(new LifeInsurance(insuranceType, insuranceCost));
                    }
                    catch (Exception e){
                        insuranceList.add(new LifeInsurance(insuranceType, 0));
                        JOptionPane.showMessageDialog(null, String.format("%s%n%s", e.getMessage(), "Cost temporarily set to $0"));
                    }
                    JOptionPane.showMessageDialog(null,"Life insurance added to list");
                    break;
            }
        }

        //convert list to array
        insurances = new Insurance[insuranceList.size()];
        insurances = insuranceList.toArray(insurances);

        //show all added insurances
        for (int i = 0; i < insurances.length; i++) {
            //ask whether client wants to change
            int selectedOption = JOptionPane.showConfirmDialog(null,
                    String.format("%s#%d?%n%s%n", "Change data for insurance ", i+1, insurances[i].displayInfo()),
                    "Set premiums",
                    JOptionPane.YES_NO_OPTION);
            boolean changePremiums = (selectedOption == JOptionPane.YES_OPTION);
            while (changePremiums){
                double newPremium = Double.parseDouble(JOptionPane.showInputDialog("Please enter new monthly premiums"));
                try{
                    insurances[i].setInsuranceCost(newPremium);
                    changePremiums = false;
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            JOptionPane.showMessageDialog(null, String.format("%s#%d%n%s%n", "Final details for ", i+1, insurances[i].displayInfo()));
        }
    }
}
