package exercise1;

public class LifeInsurance extends Insurance {
    public void setInsuranceCost(double newInsuranceCost) {
        super.setCost(newInsuranceCost);
    }

    public String displayInsuranceInfo(){
        return String.format("%s%n%s %s%n%s %.2f",
                "Life Insurance",
                "Insurance Type:",
                super.getInsuranceType(),
                "Insurance Cost:",
                super.getCost()
        );
    }

    public LifeInsurance(String insuranceType, double cost) {
        super(insuranceType, cost);
    }
}
