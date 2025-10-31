//Practice 09/02/2025

import java.util.Scanner;

public class Hellocopy{

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String name;

        System.out.println("Hello, What is your name?") ; 
        name = input.nextLine();
        System.out.println("Nice to meet you" + name);
        input.close();
    }
}