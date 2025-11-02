/**
 * Lab Title: BankAccount
 * Course: CIS 254
 * Description: Bank Account Application with try/catch test cases.
 *
 * @author Wonmin Song (BankAccount.java)
 * @author Joel Odessky (Application.java)
 * @since 10/30/2025
 */
public class Application {

    public static void main(String[] args) {

        int option = 0;
        double amount = 0.0;
        BankAccount account = new BankAccount (100);
        System.out.println("New Account Balance: " + account.getBalance());
        try {
            System.out.println("Withdrawing 200");
            account.withdraw(200);
            System.out.println("New Balance: " + account.getBalance());
            System.out.println("Depositing 1000");
            account.deposit(1000);
            System.out.println("New Balance: " + account.getBalance());
            System.out.println("Withdrawing 200");
            account.withdraw(200);
            System.out.println("New Balance: " + account.getBalance());
            System.out.println("*************************************");
            System.out.println("Withdrawing 2000");
            account.withdraw(2000);
            System.out.println("New Balance: " + account.getBalance());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Withdrawing -100");
            account.withdraw(-100);
            System.out.println("New Balance: " + account.getBalance());

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
            System.out.println(account.getStatement());

        try { 
            System.out.println("Depositing -100");
            account.deposit(-100);
            System.out.println("New Balance: " + account.getBalance());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
