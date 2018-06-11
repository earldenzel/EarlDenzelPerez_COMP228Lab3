package exercise1;

public class HealthInsurance extends Insurance{
    public void setInsuranceCost(double newInsuranceCost) {
        super.setCost(newInsuranceCost);
    }

    public String displayInsuranceInfo(){
        return String.format("%s%n%s %s%n%s %.2f",
                "Health Insurance",
                "Insurance Type:",
                super.getInsuranceType(),
                "Insurance Cost:",
                super.getCost()
                );
    }

    public HealthInsurance(String insuranceType, double cost) {
        super(insuranceType, cost);
    }
}
