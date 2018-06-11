package exercise1;

public class HealthInsurance extends Insurance{
    @Override
    public void setInsuranceCost(double newInsuranceCost) {
        super.setCost(newInsuranceCost);
    }

    @Override
    public String displayInfo(){
        return String.format("%s%n%s %s%n%s $%.2f",
                "Health Insurance",
                "Insurance Type:",
                super.getInsuranceType(),
                "Insurance Cost:",
                super.getCost()
                );
    }

    //constructor
    public HealthInsurance(String insuranceType, double cost) {
        super(insuranceType, cost);
    }
}
