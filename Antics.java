
/**
* Description: This program provides several string-processing utilities,
* including palindrome, abecedarian, pangram, and capitalization checks.
* @author Jonah Dy (menu, isPalindrome, and isAbecedarian)
* @author Wonmin Song (isPangram and capitalizeFirstLetter)
* @since 10/03/2025
*/

import java.util.Scanner;

/**
 * The {@code Antics} class provides a simple console-based menu
 * that allows the user to perform various string operations.
 * <p>
 * Menu options include:
 * <ul>
 *   <li>Checking if a string is a palindrome</li>
 *   <li>Checking if a string is abecedarian</li>
 *   <li>Checking if a string is a pangram</li>
 *   <li>Capitalizing only the first letter of a string</li>
 * </ul>
 * The program continues to run until the user chooses to quit.
 */
public class Antics {

    /**
     * The entry point of the program.
     * Displays a menu to the user, accepts input, and calls
     * the appropriate string processing methods based on the user's choice.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n+++++ String Menu +++++");
            System.out.println("1. Check if Palindrome");
            System.out.println("2. Check if Abecedarian");
            System.out.println("3. Check if Pangram");
            System.out.println("4. Capitalize First Letter");
            System.out.println("0. Quit");
            System.out.print("Enter your choice (0-4): ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter a word or sentence: ");
                    String palindromeInput = scanner.nextLine();
                    System.out.println("Is palindrome: " + isPalindrome(palindromeInput));
                    break;
                case 2:
                    System.out.print("Enter a word or sentence: ");
                    String abecedarianInput = scanner.nextLine();
                    System.out.println("Is abecedarian: " + isAbecedarian(abecedarianInput));
                    break;
                case 3:
                    System.out.print("Enter a sentence: ");
                    String pangramInput = scanner.nextLine();
                    System.out.println("Is pangram: " + isPangram(pangramInput));
                    break;
                case 4:
                    System.out.print("Enter a word or sentence: ");
                    String capitalizeInput = scanner.nextLine();
                    System.out.println("Capitalized: " + capitalizeFirstLetter(capitalizeInput));
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }

        } while (choice != 0);

        scanner.close();
    }

    /**
     * Says whether a given string is a palindrome.
     * 
     * @param input the string to check
     * @return {@code true} if the string is a palindrome; {@code false} otherwise
     */
    public static boolean isPalindrome(String input) {
        String cleaned = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    } 
    /**
     * Says whether a given string is abecedarian.
     * A string is abecedarian if its letters appear in alphabetical order.
     *
     * @param input the string to check
     * @return {@code true} if the string is abecedarian; {@code false} otherwise
     */
    public static boolean isAbecedarian(String input) {
        String cleaned = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
        for (int i = 0; i < cleaned.length() - 1; i++) {
            if (cleaned.charAt(i) > cleaned.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Says whether a given string is a pangram.
     * A pangram contains every letter of the English alphabet at least once.
     *
     * @param input the string to check
     * @return {@code true} if the string is a pangram; {@code false} otherwise
     */
    public static boolean isPangram(String input) {
        if (input == null) return false;
        String cleaned = input.toLowerCase();
        for (char c = 'a'; c <= 'z'; c++) {
            if (cleaned.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Capitalizes only the first letter of the given string.
     * If the string is null or empty, it is returned unchanged.
     *
     * @param input the string to capitalize
     * @return the input string with its first letter capitalized
     */
    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
        
    }    
}
