import java.util.Random;
import java.util.Scanner;

/**
 * A program that lets the user play two games:
 * "Rock, Paper, Scissors" and "Number Guess."
 * The user can select which game to play from a main menu 
 * 
 * @author Wonmin Song
 * @author Jonah Dy
 * @since 10/15/2025
 */
public class RandomGame {

    private static final int GUESS_MIN = 1;
    private static final int GUESS_MAX = 100;
    private static final int MAX_TRIES  = 5;


    /**
     * The main method
     * Establishes Scanner object and starts the main menu.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);
        scanner.close();
    }

    /**
     * Displays the main menu that allows the user to choose between
     * "Rock, Paper, Scissors," "Number Guess," or "Quit."
     * 
     * @param scanner Scanner object for user input.
     */
    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Play Rock, Paper, Scissors");
            System.out.println("2. Play Number Guess");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                playRockPaperScissors(scanner);
            } else if (choice == 2) {
                playNumberGuess(scanner);
            } else if (choice == 3) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    /**
     * Rock, Paper, Scissors game.
     * User selects a move (1–3), and the computer randomly selects a move.
     * The winner is determined based on standard RPS game rules.
     * After each round, the user can choose to play again, switch games, or quit.
     * 
     * @param scanner Scanner object for user input.
     */
    public static void playRockPaperScissors(Scanner scanner) {
        Random random = new Random();

        while (true) {
            System.out.println("\n=== Rock, Paper, Scissors ===");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.print("Enter your move (1-3): ");

            int userMove = scanner.nextInt();
            if (userMove < 1 || userMove > 3) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            int computerMove = random.nextInt(3) + 1;
            String[] moves = {"Rock", "Paper", "Scissors"};

            System.out.println("You chose: " + moves[userMove - 1]);
            System.out.println("Computer chose: " + moves[computerMove - 1]);

            // Determine the winner
            if (userMove == computerMove) {
                System.out.println("It's a Tie!");
            } else if ((userMove == 1 && computerMove == 3) ||
                       (userMove == 2 && computerMove == 1) ||
                       (userMove == 3 && computerMove == 2)) {
                        
                        System.out.println("You Win!");
            } else {
                System.out.println("You Lose!");
            }

            // Ask user for next action
            if (!postGameOptions(scanner)) {
                break;
            }
        }
    }

    /**
     * Number Guess game.
     * The computer randomly selects a number between 1 and 100.
     * The user has 5 attempts to guess the number.
     * The program gives feedback if the guess is too high or too low.
     * If the user guesses correctly, they win; otherwise, they lose after 5 incorrect guesses.
     * After each round, the user can play again, switch games, or quit.
     * 
     * @param scanner Scanner object for user input.
     */
public static void playNumberGuess(Scanner scanner) {
    Random random = new Random();

    while (true) { 
        int randomNumber = random.nextInt(GUESS_MAX - GUESS_MIN + 1) + GUESS_MIN;
        int tries = MAX_TRIES;
        boolean won = false;

        System.out.println("\n=== Number Guess ===");
        System.out.println("I'm thinking of a number between " + GUESS_MIN + " and " + GUESS_MAX + ".");
        System.out.print("Guess what it is. You have " + tries + " tries: ");

        for (int i = tries; i > 0; i--) {
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("Please enter an integer: ");
            }
            int guess = scanner.nextInt();

            if (guess < GUESS_MIN || guess > GUESS_MAX) {
                System.out.print("Out of range! Enter " + GUESS_MIN + "~" + GUESS_MAX + ": ");
                i++; 
                continue;
            }

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

        if (!postGameOptions(scanner)) {
            break; 
        }
    }
}

    /**
     * Handles the post-game options menu that appears after each round.
     * The user can choose to play again, switch to a different game, or quit.
     * 
     * @param scanner Scanner object for user input.
     * @return {@code true} if the user chooses to play the same game again;
     *         {@code false} if the user wants to switch games;
     *         the method exits the program if the user chooses to quit.
     */
    public static boolean postGameOptions(Scanner scanner) {
        while (true) {
            System.out.println("\nWhat would you like to do next?");
            System.out.println("1. Play Again");
            System.out.println("2. Play a Different Game");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");

            int option = scanner.nextInt();

            if (option == 1) {
                return true; // replay same game
            } else if (option == 2) {
                return false; // go back to main menu
            } else if (option == 3) {
                System.out.println("Thanks for playing! Goodbye!");
                System.exit(0); // end program
            } else {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }
    }
}
