package exercise2;

public class FullTimeStudent extends Student {
    @Override
    public double calculateTuition() {
        return 2000;
    }

    //constructor
    public FullTimeStudent(String name) {
        super(name);
        super.setFullTime(true);
    }
    
    @Override
    public String toString(){
        return String.format("%s%s%n%s$%.2f",
                "Full-time Student: ",
                super.getName(),
                "Tuition: ",
                calculateTuition());
    }
}
