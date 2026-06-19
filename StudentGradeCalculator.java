import java.util.Scanner;
public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== DECODELABS RULES ENGINE: STUDENT GRADE CALCULATOR ===");
        System.out.print("Enter the number of subjects: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid whole number.");
            scanner.next(); // Clear invalid input
            System.out.print("Enter the number of subjects: ");
        }
        int numSubjects = scanner.nextInt();
        if (numSubjects <= 0) {
            System.out.println("Error: Number of subjects must be greater than 0. Exiting program.");
            scanner.close();
            return;
        }
        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
                if (scanner.hasNextInt()) {
                    int inputMarks = scanner.nextInt();
                    if (inputMarks >= 0 && inputMarks <= 100) {
                        marks[i] = inputMarks;
                        totalMarks += inputMarks;
                        break;
                    } else {
                        System.out.println("Invalid entry. Marks must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid entry. Please enter an integer value.");
                    scanner.next();
                }
            }
        }
        double averagePercentage = (double) totalMarks / numSubjects;
        String grade;
        String passFailStatus;
        if (averagePercentage >= 90) {
            grade = "A+";
            passFailStatus = "PASSED (With Distinction)";
        } else if (averagePercentage >= 80) {
            grade = "A";
            passFailStatus = "PASSED";
        } else if (averagePercentage >= 70) {
            grade = "B";
            passFailStatus = "PASSED";
        } else if (averagePercentage >= 60) {
            grade = "C";
            passFailStatus = "PASSED";
        } else if (averagePercentage >= 50) {
            grade = "D";
            passFailStatus = "PASSED";
        } else {
            grade = "F";
            passFailStatus = "FAILED";
        }


        System.out.println("\n-------------------------------------------");
        System.out.println("             ACADEMIC REPORT CARD          ");
        System.out.println("-------------------------------------------");
        System.out.println("Total Subjects     : " + numSubjects);
        System.out.println("Total Marks Earned : " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf("Average Percentage : %.2f%%\n", averagePercentage);
        System.out.println("Assigned Grade     : " + grade);
        System.out.println("Academic Status    : " + passFailStatus);
        System.out.println("-------------------------------------------");
        System.out.println(" Results verified.");
       

        scanner.close();
    }
}
