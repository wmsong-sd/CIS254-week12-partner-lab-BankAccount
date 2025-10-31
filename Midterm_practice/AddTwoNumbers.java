//🎯 목표: 사용자로부터 숫자 입력받고 계산

import java.util.Scanner;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int a = input.nextInt();

        System.out.print("Enter the second number: ");
        int b = input.nextInt();

        int sum = a+b;

        System.out.println("The sum is: " + sum);
        input.close();
    }
}

    //🎯 목표: 클래스 안에 여러 메서드 두고, main() 에서 호출

    public static int add (int x, int y) {
        return x + y;
    }

    public static int subtract(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int a = nextInt();

        System.out.print("Enter the second number: ");
        int b = nextInt();

        System.out.println("Add: " + add(a, b));
        System.out.println("Subtract: " + subtract(a, b));
        System.out.println("Multiply: " + multiply(a, b));

        in.close();
    }
