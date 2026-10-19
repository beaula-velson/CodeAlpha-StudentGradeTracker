import java.util.Scanner;

class Student {
    String name;
    int mark;

    Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    String calculateGrade() {
        if (mark >= 90) {
            return "A";
        } else if (mark >= 80) {
            return "B";
        } else if (mark >= 70) {
            return "C";
        } else if (mark >= 60) {
            return "D";
        } else {
            return "Fail";
        }
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Mark: " + mark);
        System.out.println("Grade: " + calculateGrade());
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        while (n <= 0) {
            System.out.println("Invalid number of students!");
            System.out.print("Enter number of students again: ");
            n = sc.nextInt();
        }

        sc.nextLine();

        Student[] students = new Student[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter mark: ");
            int mark = sc.nextInt();

            while (mark < 0 || mark > 100) {
                System.out.println("Invalid! Marks must be 0 to 100.");
                System.out.print("Enter mark again: ");
                mark = sc.nextInt();
            }

            sc.nextLine();

            students[i] = new Student(name, mark);
            total += mark;
        }

        int highest = students[0].mark;
        int lowest = students[0].mark;
        String topStudent = students[0].name;
        String lowestStudent = students[0].name;

        System.out.println("\n--- Student Details ---");

        for (int i = 0; i < n; i++) {
            students[i].displayDetails();
            System.out.println();

            if (students[i].mark > highest) {
                highest = students[i].mark;
                topStudent = students[i].name;
            }

            if (students[i].mark < lowest) {
                lowest = students[i].mark;
                lowestStudent = students[i].name;
            }
        }

        double average = (double) total / n;

        System.out.println("--- Class Summary ---");
        System.out.println("Total Marks: " + total);
        System.out.printf("Average Mark: %.2f%n", average);
        System.out.println("Top Student: " + topStudent);
        System.out.println("Highest Mark: " + highest);
        System.out.println("Lowest Student: " + lowestStudent);
        System.out.println("Lowest Mark: " + lowest);

        sc.close();
    }
}
