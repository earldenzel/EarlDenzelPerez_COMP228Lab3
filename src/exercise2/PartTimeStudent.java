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

    public double calculateTuition() {
        return 100 * creditHours;
    }

    public PartTimeStudent(String name, int creditHours) {
        super(name);
        this.creditHours = creditHours;
        super.setFullTime(false);
    }
}
