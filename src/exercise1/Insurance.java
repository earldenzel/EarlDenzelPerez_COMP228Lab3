package exercise1;

/*
* Let Insurance be an abstract superclass and Health and Life two of its subclasses that describe respectively
* health insurance and life insurance.
*
* The Insurance class defines an instance variable of type String to describe the type of insurance
* and an instance variable of type double to hold the monthly cost of that insurance.
*
* Implement the get methods for both variables of class Insurance.
* Declare also two abstract methods named setInsuranceCost() and displayInfo() for this class.
* The Life and Health class should implement setInsuranceCost and display methods by setting
* the appropriate monthly fee and display the information for each insurance type.
*
* Write a driver class to test this hierarchy. This application should ask the user to enter the
* type of insurance and its monthly fee. Then, will create the appropriate object (Life or Health)
* and display the insurance information.
*
* As you create each insurance object, place an Insurance reference to each new Insurance object into an array.
* Each class has its own setInsuranceCost method. Write a polymorphic screen manager that walks through the array
* sending setInsuranceCost messages to each object in the array and displaying this information on the screen.
*/

public abstract class Insurance {
    private final String insuranceType;
    private double cost;

    //abstract methods
    public abstract void setInsuranceCost(double newInsuranceCost);
    public abstract String displayInfo();

    //constructor
    public Insurance(String insuranceType, double cost) {
        checkInsuranceCost(cost);
        this.insuranceType = insuranceType;
        this.cost = cost;
    }

    //checkers
    private static void checkInsuranceCost(double cost){
        if (cost < 0){
            throw new IllegalArgumentException("Cost cannot be negative");
        }
    }


    //getters
    public String getInsuranceType() {
        return insuranceType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        checkInsuranceCost(cost);
        this.cost = cost;
    }
}
