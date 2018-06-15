package exercise1;

public class LifeInsurance extends Insurance {
    @Override
    public void setInsuranceCost(double newInsuranceCost) {
        super.setCost(newInsuranceCost);
    }

    @Override
    public String displayInfo(){
        return String.format("%s%n%s %s%n%s $%.2f%n",
                "Life Insurance",
                "Insurance Type:",
                super.getInsuranceType(),
                "Insurance Cost:",
                super.getCost()
        );
    }

    //constructor
    public LifeInsurance(String insuranceType, double cost) {
        super(insuranceType, cost);
    }
}
