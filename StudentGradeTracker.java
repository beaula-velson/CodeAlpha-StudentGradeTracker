import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        while(n <= 0){
            System.out.println("Invalid number of students!");
            System.out.print("Enter number of students again: ");
            n = sc.nextInt();
        }
        sc.nextLine();

        String[] names = new String[n];
        int[] marks = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {

            System.out.print("Enter student name: ");
            names[i] = sc.nextLine();

            System.out.print("Enter mark: ");
            marks[i] = sc.nextInt();

            while (marks[i] < 0 || marks[i] > 100) {
            System.out.println("Invalid! Enter marks between 0 and 100.");
            System.out.print("Enter mark again: ");
            marks[i] = sc.nextInt();
            }
            total = total + marks[i];
            sc.nextLine();
        }
        int highest = marks[0];
        int topIndex = 0;
        int lowest = marks[0];
        int lowestIndex = 0;
        for (int i = 0; i < n; i++) {
            if (marks[i] > highest) {
              highest = marks[i];
               topIndex = i;
             }
        }
        for (int i = 0; i < n; i++) {
            if (marks[i] < lowest) {
              lowest = marks[i];
               lowestIndex = i;
             }
        }
           
            
        System.out.println("\n--- Student Details ---");

        for (int i = 0; i < n; i++) {
            System.out.println("Name: " + names[i]);
            System.out.println("Mark: " + marks[i]);
            if(marks[i] >= 90){
                System.out.println("Grade:  A" );
            }
            else if(marks[i] >= 80 ){
                System.out.println("Grade:  B" );
            }
            else if(marks[i] >= 70 ){
                System.out.println("Grade:  C" );
            }
            else if(marks[i] >= 60 ){
                System.out.println("Grade:  D" );
            }

            else{
                System.out.println("Grade:  Fail" );}

            System.out.println();
        }
           
        
        System.out.println( );
        System.out.println("---- Class Summary ----"); 

        double average = (double) total / n;

        System.out.println("Total Marks: " + total);
        System.out.println("Average Mark: " + average);  
        System.out.println("Top Student: " + names[topIndex]);
        System.out.println("Highest Mark: " + highest); 
        System.out.println("Lowest Student: " + names[lowestIndex]);
        System.out.println("Lowest Mark: " + lowest);   
             

        sc.close();
    }
}