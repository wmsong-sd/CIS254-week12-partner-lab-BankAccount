
/**
* Description: A console-based mini game program with a Guessing Game and a placeholder for Rock-Paper-Scissors.
* @author Jonah Dy (menu, isPalindrome, and isAbecedarian)
* @author Wonmin Song (isPangram and capitalizeFirstLetter)
* @since 10/20/2025
*/

import java.util.Random;
import java.util.Scanner;

public class RandomGame {
    /**
     * Displays the main menu and returns the user's choice.
     *
     * @param in Scanner for user input
     * @return user's choice (1, 2, or 3)
     */
    public static int menu(Scanner in) {
        System.out.print("Do you want to play? (Y/N): ");
        String yn = in.next();
        if (!yn.equalsIgnoreCase("y")) {
            System.out.println("Goodbye!");
            return 3; // Quit
        }

        System.out.println("1. Guessing Game");
        System.out.println("2. Rock, Paper, Scissors");
        System.out.println("3. Quit");
        System.out.print("Enter your choice: ");

        while (!in.hasNextInt()) {
            in.next();
            System.out.print("Enter 1, 2, or 3: ");
        }
        return in.nextInt();
    }

    /**
     * Plays a number guessing game.
     * The computer picks a random number between 1 and 100,
     * and the user has 5 tries to guess it.
     *
     * @param in Scanner for user input
     */
    public static void playGuessingGame(Scanner in) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1;
        int tries = 5;
        boolean won = false;

        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.print("Guess what it is. You have " + tries + " tries: ");

        for (int i = tries; i > 0; i--) {
            while (!in.hasNextInt()) {
                in.next();
                System.out.print("Please enter an integer: ");
            }
            int guess = in.nextInt();

            if (guess == randomNumber) {
                System.out.println("You got it!");
                won = true;
                break;
            } else if (guess < randomNumber) {
                if (i - 1 > 0) {
                    System.out.print("Nope! Too low. Try again (" + (i - 1) + " tries left): ");
                }
            } else {
                if (i - 1 > 0) {
                    System.out.print("Nope! Too high. Try again (" + (i - 1) + " tries left): ");
                }
            }
        }

        if (!won) {
            System.out.println("Nope! You lost. The number was " + randomNumber + ".");
        }
    }

    /**
     * Placeholder for Rock-Paper-Scissors game.
     *
     * @param in Scanner for user input
     */
    public static void playRockPaperScissors(Scanner in) {
        System.out.println("Rock, Paper, Scissors will be added by your teammate.");
    }

    /**
     * Program entry point.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            choice = menu(in);
            if (choice == 1) {
                playGuessingGame(in);
            } else if (choice == 2) {
                playRockPaperScissors(in);
            } else if (choice == 3) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 3);

        in.close();
    }
}
