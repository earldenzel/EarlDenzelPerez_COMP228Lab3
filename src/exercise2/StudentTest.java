package exercise2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//driver class
public class StudentTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();

        //add students until user decides to stop
        String[] buttons = { "Add full-time student", "Add part-time student", "Quit" };
        int rc = 0;
        String name;
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
                    name = JOptionPane.showInputDialog("Enter student's name");
                    int creditHours = Integer.parseInt(JOptionPane.showInputDialog("Please enter credit hours"));
                    students.add(new PartTimeStudent(name, creditHours));
                    JOptionPane.showMessageDialog(null, "Part-time student added!");
                    break;
                default: //quit
                    break;
            }
        }

        for (Student student: students){
            JOptionPane.showMessageDialog(null, student);
        }
    }
}
