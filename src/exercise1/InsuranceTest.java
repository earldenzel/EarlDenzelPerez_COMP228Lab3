package exercise1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//driver class
public class InsuranceTest {
    public static void main(String[] args) {
        Insurance[] insurances; //exercise requires array, not array list
        List<Insurance> insuranceList = new ArrayList<Insurance>(); //we're using lists to make it easy to think

        String[] buttons = { "Health Insurance", "Life Insurance", "Quit"};
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
                    insuranceList.add(new HealthInsurance(insuranceType,insuranceCost));
                    JOptionPane.showMessageDialog(null,"Health insurance added to list");
                    break;
                case 1: //life insurance
                    insuranceType = JOptionPane.showInputDialog("Please enter life insurance type");
                    insuranceCost = Double.parseDouble(JOptionPane.showInputDialog("Please enter monthly fee for " + insuranceType));
                    insuranceList.add(new LifeInsurance(insuranceType,insuranceCost));
                    JOptionPane.showMessageDialog(null,"Life insurance added to list");
                    break;
            }
        }

        //convert list to array
        insurances = new Insurance[insuranceList.size()];
        insurances = insuranceList.toArray(insurances);

        for (Insurance insurance: insurances) {
            JOptionPane.showMessageDialog(null, insurance.displayInfo());
        }
    }
}
