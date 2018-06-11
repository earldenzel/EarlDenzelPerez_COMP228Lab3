package exercise2;

public class PartTimeStudent extends Student {
    private int creditHours;

    //getter and setter
    public int getCreditHours() {
        return creditHours;
    }
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    @Override
    public double calculateTuition() {
        return 100 * creditHours;
    }

    @Override
    public String toString(){
        return String.format("%s%s%n%s$%.2f",
                "Part-time Student: ",
                super.getName(),
                "Tuition: ",
                calculateTuition());
    }

    //constructor
    public PartTimeStudent(String name, int creditHours) {
        super(name);
        this.creditHours = creditHours;
        super.setFullTime(false);
    }
}
