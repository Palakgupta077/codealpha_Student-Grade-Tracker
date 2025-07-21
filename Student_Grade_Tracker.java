import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Double> marks;

    Student(String name) {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    double getTotal() {
        double sum = 0;
        for (double mark : marks) { 
            sum += mark;
        }
        return sum;
    }

    double getAverage() {
        if (marks.size() == 0) return 0;
        return getTotal() / marks.size();
    }
}

public class tempCodeRunnerFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter number of subjects per student: ");
        int numSubjects = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();

            Student student = new Student(name);

            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter marks for Subject " + (j + 1) + ": ");
                double mark = sc.nextDouble();
                student.marks.add(mark);
            }
            sc.nextLine(); // Consume newline after last mark
            students.add(student);
        }

        // Stats calculation
        double totalAll = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;

        for (Student s : students) {
            double total = s.getTotal();
            totalAll += total;
            if (total > highest) highest = total;
            if (total < lowest) lowest = total;
        }

        double averageAll = totalAll / students.size();

        // Print report
        System.out.println("\n========== STUDENT GRADE REPORT ==========");
        for (Student s : students) {
            System.out.println("Name: " + s.name);
            for (int i = 0; i < s.marks.size(); i++) {
                System.out.println("  Subject " + (i + 1) + ": " + s.marks.get(i));
            }
            System.out.println("  Total Marks: " + s.getTotal());
            System.out.println("  Average Marks: " + s.getAverage());
            System.out.println();
        }

        System.out.println("Class Average Total: " + averageAll);
        System.out.println("Highest Total Marks: " + highest);
        System.out.println("Lowest Total Marks: " + lowest);

        sc.close();
    }
}


