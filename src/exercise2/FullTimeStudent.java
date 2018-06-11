package exercise2;

public class FullTimeStudent extends Student {
    public double calculateTuition() {
        return 2000;
    }

    public FullTimeStudent(String name) {
        super(name);
        super.setFullTime(true);
    }
}
