import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input marks for Physics, Chemistry, and Maths
        System.out.print("Enter marks in Physics: ");
        int physics = scanner.nextInt();

        System.out.print("Enter marks in Chemistry: ");
        int chemistry = scanner.nextInt();

        System.out.print("Enter marks in Maths: ");
        int maths = scanner.nextInt();

        // Calculate total marks, average marks, and percentage
        int totalMarks = physics + chemistry + maths;
        double averageMarks = totalMarks / 3.0;
        double percentage = (totalMarks / 300.0) * 100;

        // Determine grade and remarks based on percentage
        String grade, remarks;

        if (percentage >= 80) {
            grade = "A";
            remarks = "Level 4,above agency-normalized standards";
        } else if (percentage >= 70&&percentage<80) {
            grade = "B";
            remarks = "Level 3,at agency-normalized standards";
        } else if (percentage >= 60&&percentage<70) {
            grade = "C";
            remarks = "Level 2,below,but approaching agency-normalized standards";
        } else if (percentage >= 50&&percentage<60) {
            grade = "D";
            remarks = "Level 1,well below agency-normalized standards";
        } else if (percentage >= 40&&percentage<50) {
            grade = "E";
            remarks = "Level 1,too below agency-normalized standards";
        } else {
            grade = "F";
            remarks = "Remedial standards";
        }

        // Output the results
        System.out.println("\nResults:");
        System.out.println("Physics Marks: " + physics);
        System.out.println("Chemistry Marks: " + chemistry);
        System.out.println("Maths Marks: " + maths);
        System.out.println("Total Marks: " + totalMarks + "/300");
        System.out.println("Average Marks: " + averageMarks);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);

        scanner.close();
    }
}