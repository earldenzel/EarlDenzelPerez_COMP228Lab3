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
    private String name;
    private Boolean isFullTime;

    public abstract double calculateTuition();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFullTime(Boolean fullTime) {
        isFullTime = fullTime;
    }
}
