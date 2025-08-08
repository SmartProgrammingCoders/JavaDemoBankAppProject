import java.util.Scanner;

public class BankApp
{
    private static double balance = 0.0;

    // Method to display the main menu
    public static void displayMenu()
    {
        System.out.println("\nWelcome to Simple Bank");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Please select an option (1-4): ");
    }

    // Method to check the balance
    public static void checkBalance() {
        System.out.println("Your current balance is: Rs. " + balance);
    }

    // Method to deposit money
    public static void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount to deposit: Rs. ");
        double depositAmount = scanner.nextDouble();
        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("You have successfully deposited: Rs. " + depositAmount);
        } else {
            System.out.println("Please enter a valid amount.");
        }
    }

    // Method to withdraw money
    public static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: Rs. ");
        double withdrawAmount = scanner.nextDouble();
        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.println("You have successfully withdrawn: Rs. " + withdrawAmount);
        } else if (withdrawAmount > balance) {
            System.out.println("Insufficient balance. You cannot withdraw more than your balance.");
        } else {
            System.out.println("Please enter a valid amount.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice;

        do {
            displayMenu();
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using Simple Bank. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (userChoice != 4);

        scanner.close();
    }
}
