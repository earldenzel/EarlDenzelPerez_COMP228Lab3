package exercise2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//driver class
public class StudentTest {
    public static void main(String[] args) {
        //variables
        List<Student> students = new ArrayList<Student>();
        String[] buttons = { "Add full-time student", "Add part-time student", "Quit" };
        int rc = 0;
        String name;

        //add students until user decides to stop
        while (rc != 2){
            rc = JOptionPane.showOptionDialog(
                    null,
                    "What type of student will you add?",
                    "Add student", JOptionPane.DEFAULT_OPTION, 3, null, buttons, buttons[2]);
            switch (rc){
                case 0: //full-time student
                    name = JOptionPane.showInputDialog("Enter student's name");
                    students.add(new FullTimeStudent(name));
                    JOptionPane.showMessageDialog(null, "Full-time student added!");
                    break;
                case 1: //part-time student
                    boolean validStudent = false;
                    while (!validStudent) {
                        name = JOptionPane.showInputDialog("Enter student's name");
                        double creditHours = Double.parseDouble(JOptionPane.showInputDialog("Please enter credit hours"));
                        try {
                            students.add(new PartTimeStudent(name, creditHours));
                            validStudent = true;
                        }
                        catch (IllegalArgumentException e){
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Part-time student added!");
                    break;
                default: //quit
                    break;
            }
        }

        //show all added students
        String message = "";
        for (Student student: students){
            message += String.format("%s%n", student);
        }
        JOptionPane.showMessageDialog(null, message);
    }
}
