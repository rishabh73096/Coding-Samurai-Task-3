import java.util.Scanner;

public class Student_grade_calculater {
    public static void displayMenu() {
        System.out.println("Enter grades for:");
        System.out.println("1. Assignments");
        System.out.println("2. Quizzes");
        System.out.println("3. Midterm Exams");
        System.out.println("4. Final Exam");
        System.out.println("5. Calculate Final Grade");
    }
    public static double inputGrade(String gradeType) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your grade for " + gradeType + " (0-100):");
        return scanner.nextDouble();
    }
    public static char getLetterGrade(double grade) {
        if (grade >= 90) return 'A';
        if (grade >= 80) return 'B';
        if (grade >= 70) return 'C';
        if (grade >= 60) return 'D';
        return 'F';
    }
    public static double calculateFinalGrade(double assignments, double quizzes, double midterm, double finalExam) {
        double weightAssignments = 0.25;
        double weightQuizzes = 0.25;
        double weightMidterm = 0.25;
        double weightFinalExam = 0.25;
    
        return (assignments * weightAssignments) + (quizzes * weightQuizzes) + (midterm * weightMidterm) + (finalExam * weightFinalExam);
    }
    public static void displayFinalGrade(double grade) {
        System.out.println("Your final grade is: " + grade + " (" + getLetterGrade(grade) + ")");
    }
    public static boolean isValidGrade(double grade) {
        return grade >= 0 && grade <= 100;
    }
    
    public static void main(String[] args) {
        double assignments = 0, quizzes = 0, midterm = 0, finalExam = 0;
        while(true) {
            displayMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    assignments = inputGrade("Assignments");
                    if(!isValidGrade(assignments)) {
                        System.out.println("Invalid grade entered. Try again.");
                        assignments = 0;
                    }
                    break;
                case 2:
                    quizzes = inputGrade("Quizzes");
                    if(!isValidGrade(quizzes)) {
                        System.out.println("Invalid grade entered. Try again.");
                        quizzes = 0;
                    }
                    break;
                case 3:
                    midterm = inputGrade("Midterm Exams");
                    if(!isValidGrade(midterm)) {
                        System.out.println("Invalid grade entered. Try again.");
                        midterm = 0;
                    }
                    break;
                case 4:
                    finalExam = inputGrade("Final Exam");
                    if(!isValidGrade(finalExam)) {
                        System.out.println("Invalid grade entered. Try again.");
                        finalExam = 0;
                    }
                    break;
                case 5:
                    double finalGrade = calculateFinalGrade(assignments, quizzes, midterm, finalExam);
                    displayFinalGrade(finalGrade);
                    return;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
    
}
