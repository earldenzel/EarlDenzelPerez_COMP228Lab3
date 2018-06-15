package exercise2;

public class PartTimeStudent extends Student {
    private double creditHours;

    //getter and setter
    public double getCreditHours() {
        return creditHours;
    }
    public void setCreditHours(double creditHours) {
        checkValidHours(creditHours);
        this.creditHours = creditHours;
    }

    @Override
    public double calculateTuition() {
        return 100 * creditHours;
    }

    @Override
    public String toString(){
        return String.format("%s%s%n%s%.2f%n%s$%.2f%n",
                "Part-time Student: ",
                super.getName(),
                "Credit Hours: ", getCreditHours(),
                "Tuition: ",
                calculateTuition());
    }

    public static void checkValidHours(double creditHours){
        //maximum creditHours is 80
        if (creditHours < 0 || creditHours >80){
            throw new IllegalArgumentException("Credit hours per week must be between 0 and 80 hours");
        }
    }

    //constructor
    public PartTimeStudent(String name, double creditHours) {
        super(name, false);
        checkValidHours(creditHours);
        this.creditHours = creditHours;
    }
}
