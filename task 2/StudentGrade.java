import java.util.*;

public class StudentGrade {
    public static void main(String[] args) {
        // Create a new Scanner object to read input from the console
        Scanner in = new Scanner(System.in);
        
        // Prompt the user to enter the student's name and store it in a variable
        System.out.print("Please enter Student Name: ");
        String sName = in.nextLine();

        // Declare a variable to store the number of subjects
        int subNum;
        do {
            // Prompt the user to enter the number of subjects and validate it
            System.out.print("Enter number of subjects: ");
            subNum = in.nextInt();
            if (subNum <= 0) {
                System.out.println("Please enter a valid number of subjects.");
            }
        } while (subNum <= 0);

        // Prompt the user to enter subjects and their corresponding marks
        System.out.println("Enter subjects and marks: ");
        // Create a LinkedHashMap to store subjects and their marks
        LinkedHashMap<String, Integer> marks = new LinkedHashMap<>();
        int subtotal = 0;

        // Iterate through each subject and its corresponding mark
        for (int i = 1; i <= subNum; i++) {
            // Prompt the user to enter the subject name and store it
            System.out.print("Enter " + i + " subject: ");
            String subject = in.next();
            
            int val;
            // Validate the input for marks and handle exceptions
            do {
                System.out.print("Enter marks in " + subject + ": ");
                try {
                    val = in.nextInt();
                    if (val < 0 || val > 100) {
                        System.out.println("Please enter valid marks between 0 and 100.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    // Clear the input buffer and set val to trigger re-entry
                    in.nextLine();
                    val = -1;
                }
            } while (val < 0 || val > 100);

            // Add the subject and mark to the LinkedHashMap
            marks.put(subject, val);
            // Update the subtotal with the current mark
            subtotal += val;
        }

        // Display the entered subjects and their marks
        System.out.println();
        System.out.println(marks);
        // Calculate and display the total marks obtained by the student
        System.out.println("Total Marks obtained by " + sName.toUpperCase() + " in " + marks.size() +
                " subjects out of " + marks.size() * 100 + " is: " + subtotal);
        // Calculate the average percentage
        double avg = (double) subtotal / marks.size();
        // Display the average percentage with proper formatting
        System.out.printf("Average percentage of all %d subjects is: %.2f%%%n", marks.size(), avg);
        
        // Determine the grade based on the average and display it
        String grade = switch ((int) avg / 10) {
            case 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            case 5 -> "E";
            default -> "Fail";
        };
        
        // Display the final grade
        System.out.print("Grade Scored by " + sName.toUpperCase() + " is " + grade);

        // Close the Scanner to release resources
        in.close();
    }
}
