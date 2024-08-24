import java.util.Scanner;

public class Task2 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input of marks obtained in each subject
        System.out.print("Enter the number of subjects: ");
        int TotalSubjects = sc.nextInt();

        int[] marks = new int[TotalSubjects];
        int totalMarks = 0;

        for (int i = 0; i < TotalSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }

        // Calculate Total Marks
        System.out.println("Total Marks: " + totalMarks);

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / TotalSubjects;
        System.out.println("Average Percentage: " + averagePercentage + "%");

        // Grade Calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Results
        System.out.println("Grade: " + grade);

        sc.close();
    }
}

