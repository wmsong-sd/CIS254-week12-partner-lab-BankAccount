import java.util.Scanner;

public class Convert {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
          option = menu(input);
        double originalTemp, convertedTemp;
          switch(option) {
            case 1:
                System.out.println("Enter a temperature to convert: ");
                originalTemp = input.nextDouble();
                convertedTemp = c2f(originalTemp);
                System.out.printf("%.1f oC = %.1f oF \n", originalTemp, convertedTemp);
                System.out.println("You entered option 1");
                break;
            case 2:
                System.out.println("You entered option 2");
                break;
            case 3:
                System.out.println("Good bye!");
            default:
                System.out.println("Invalid option");
                break;
        }
    }
    while(option != 3);
    input.close();

    }
    
    static int menu(Scanner in) {
        System.out.println("Choose one of the following options: ");
        System.out.println("(1) Convert from Celsius to Fahrenheit");
        System.out.println("(2) Convert from Fahrenheit to Celsius");
        System.out.println("(3) Quit");
        System.out.println("Option: ");
        int option = in.nextInt();
        return option;
    

    }
    static double c2f(double temperature) {
        return (temperature * 9 / 5 + 32);
        
    }
}
