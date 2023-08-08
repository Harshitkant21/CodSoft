package com.codSoft;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    private static final int Max_tries = 10;
    
    //Method to play the game
    public static void guess(int num, int randomNum) {
        int turns = 0;
        while (num != randomNum && turns < Max_tries) {
            if (num < randomNum) {
                System.out.println("Your guess is lower than the expected number. Think of a bit higher value.");
            } else {
                System.out.println("Your guess is higher than the expected number. Think of a bit lower value.");
            }
            turns++;
            System.out.print("Enter your next guess: ");
            num = new Scanner(System.in).nextInt();
        }

        if (num == randomNum) {
            System.out.println("Congratulations!! You got "+(100-(turns*10))+" points.");
        } else {
            System.out.println("Sorry!! You Lost. Correct number is " + randomNum);
            System.out.println("Try Again");
        }
    }

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	do {
	        System.out.println("Welcome to Number Guessing Game!!");
	        System.out.println("It is point based game maximum points will be 100.");
	        System.out.println("You have only 10 chances to win the Game. Best Of Luck!!!!");
	        Random rand = new Random();
	        int number = rand.nextInt(100) + 1; 
	
	        System.out.print("Hey, I am guessing a number from range 1-100. Can you guess that number: ");
	        int userGuess = in.nextInt();
	
	        if (userGuess < 0 || userGuess > 100) {
	            System.out.println("Invalid! Enter a valid number in range 1-100.");
	        } else {
	            guess(userGuess, number);
	        }
	        System.out.println("Do you want to play again? (yes/no): ");
    	}while("yes".equalsIgnoreCase((in.next())));        
    }
}
