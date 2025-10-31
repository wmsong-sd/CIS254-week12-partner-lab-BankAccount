/**
   Homework 5
   Description: Prints the first letters of my first and last name (W and S)
   @author Wonmin Song
   @since 09/13/2025
*/

public class Main {
    public static void main(String[] args) {

        printW(args[0]);
        System.out.println();
        printS(args[1]);
    }

    /** This method prints a letter of the alphabet using the character
        passed as a parameter
        @param letter the character used to print the letter
    */
    static void printW(String letter) {
        System.out.println(" " + letter + "     " + letter);
        System.out.println(" " + letter + "  " + letter + "  " + letter);
        System.out.println("  " + letter + " " + letter + " " + letter);
        System.out.println("   " + letter + " " + letter);
    }
    /** This method prints a letter of the alphabet using the character
        passed as a parameter
        @param letter the character used to print the letter
    */
    static void printS(String letter) {
        System.out.println(" " + letter + letter + letter );
        System.out.println(letter + "   " + letter );
        System.out.println(letter);
        System.out.println(" " + letter + letter + letter);
        System.out.println("    " + letter );
        System.out.println(letter + "   " + letter );
        System.out.println(" " + letter + letter + letter);
    }
}