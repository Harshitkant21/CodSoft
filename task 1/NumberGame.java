import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    private static final int Max_tries = 10; // Maximum number of tries allowed
    
    // Method to play the game
    public static void guess(int num, int randomNum) {
        int turns = 0; // Counter for the number of tries
        while (num != randomNum && turns < Max_tries) {
            // Provide hints to the user based on their guess
            if (num < randomNum) {
                System.out.println("Your guess is lower than the expected number. Think of a bit higher value.");
            } else {
                System.out.println("Your guess is higher than the expected number. Think of a bit lower value.");
            }
            turns++; // Increment the turn counter
            System.out.print("Enter your next guess: ");
            num = new Scanner(System.in).nextInt(); // Read the next guess from the user
        }

        // Display the result of the game based on the final guess
        if (num == randomNum) {
            System.out.println("Congratulations!! You got " + (100 - (turns * 10)) + " points.");
        } else {
            System.out.println("Sorry!! You Lost. Correct number is " + randomNum);
            System.out.println("Try Again");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do {
            // Welcome message and game instructions
            System.out.println("Welcome to Number Guessing Game!!");
            System.out.println("It is a point-based game. The maximum points you can get is 100.");
            System.out.println("You have only 10 chances to win the game. Best of luck!");
            
            Random rand = new Random();
            int number = rand.nextInt(100) + 1; // Generate a random number between 1 and 100
            
            System.out.print("Hey, I am guessing a number from range 1-100. Can you guess that number: ");
            int userGuess = in.nextInt(); // Read the user's initial guess
            
            // Check if the user's guess is out of range and provide instructions
            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Invalid! Enter a valid number in the range 1-100.");
            } else {
                guess(userGuess, number); // Call the guess method to play the game
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
        } while ("yes".equalsIgnoreCase(in.next())); // Continue the loop if the user wants to play again
        
        in.close(); // Close the scanner to release resources
    }
}
