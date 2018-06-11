package exercise1;

import javax.swing.*;

//driver class
public class InsuranceTest {
    public static void main(String[] args) {
        Boolean askNumberAgain = true;
        int insuranceObjectCount = 0;
        Insurance[] insurances;

        //i want to force number of insurance objects as a number between 1-10
        while (askNumberAgain) {
            //check if number
            try {
                insuranceObjectCount = Integer.parseInt(JOptionPane.showInputDialog("How many insurance items are we processing today?"));
                askNumberAgain = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Number of insurance objects should be a number. You will be asked to input this again.");
                askNumberAgain = true;
            }
            //check if greater than 0 or less than 11
            if (insuranceObjectCount > 0 && insuranceObjectCount < 11){
                askNumberAgain = false;
            }
            else{
                JOptionPane.showMessageDialog(null, "Number of insurance objects should be greater than 0 and less than 11. You will be asked to input this again.");
                askNumberAgain = true;
            }
        }
        System.out.println(insuranceObjectCount);

        insurances = new Insurance[insuranceObjectCount];
        //loop to create object
        for (int i = 0; i < insuranceObjectCount; i++){
            insurances[i] = CreateInsuranceObject();
        }
        for (Insurance insurance: insurances) {
            JOptionPane.showMessageDialog(null, insurance.displayInsuranceInfo());
        }
    }

    public static Insurance CreateInsuranceObject(){
        String[] buttons = { "Health Insurance", "Life Insurance"};
        Insurance insurance = null;
        int rc;
        rc = JOptionPane.showOptionDialog(
                null,
                "What type of insurance are you processing?",
                "Enter Type", JOptionPane.DEFAULT_OPTION, 3, null, buttons, buttons[1]);
        String insuranceType = JOptionPane.showInputDialog("Please enter insurance type");
        double insuranceCost = Double.parseDouble(JOptionPane.showInputDialog("Insurance cost amount?"));

        switch (rc){
            case 0: //health insurance
                insurance = new HealthInsurance(insuranceType,insuranceCost);
                break;
            case 1: //life insurance
                insurance = new LifeInsurance(insuranceType,insuranceCost);
                break;
        }

        return insurance;
    }
}
