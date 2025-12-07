import java.util.ArrayList;
import java.util.Scanner;

// ---------------- Student Class ----------------
class Student {
    String name;
    ArrayList<Integer> marks = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void addMark(int mark) {
        marks.add(mark);
    }

    double getAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.size();
    }
}

// ---------------- Grade Calculator Class ----------------
class GradeCalculator {

    static String getGrade(double avg) {
        if (avg >= 90) return "A+";
        else if (avg >= 80) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 50) return "D";
        return "F";
    }
}

// ---------------- Main Class ----------------
public class SchoolSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();

            Student s = new Student(name);

            System.out.print("Enter number of subjects: ");
            int sub = sc.nextInt();

            for (int j = 0; j < sub; j++) {
                System.out.print("Enter mark " + (j+1) + ": ");
                int mark = sc.nextInt();
                s.addMark(mark);
            }

            sc.nextLine(); // clear buffer
            students.add(s);
        }

        System.out.println("\n----- REPORT CARD -----");

        for (Student s : students) {
            double avg = s.getAverage();
            String grade = GradeCalculator.getGrade(avg);

            System.out.println("\nName: " + s.name);
            System.out.println("Average Marks: " + avg);
            System.out.println("Grade: " + grade);
        }
    }
}
