package exercise2;
/*
* Create an abstract class called Student.
* The Student class includes a name and a boolean value representing the full-time status.
*
* Include an abstract method to determine the tuition, with full-time students paying a flat fee of $2000
* and part-time students paying $100 per credit hour.
*
* Create two subclasses called FullTimeStudent, PartTimeStudent.
* Create a console application that demonstrates how to create objects of both subclasses.
* Allow the user to choose student type and enter the number of credit hours.
*/

abstract class Student {
    private final String name;
    private final boolean isFullTime;

    //abstract methods
    public abstract double calculateTuition();

    //constructor
    public Student(String name, boolean isFullTime) {
        this.name = name;
        this.isFullTime = isFullTime;
    }

    //getter and setter
    public String getName() {
        return name;
    }
    private boolean getIsFullTime(){ return isFullTime; }

}
