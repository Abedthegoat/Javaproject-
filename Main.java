package BankingSystem;


import java.util.Scanner;

class Bank {
    private String accountHolderName;
    private double balance;

    public Bank(String name, double initialBalance) {
        accountHolderName = name;
        balance = initialBalance;
    }
    
    public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        System.out.println("Deposited Succesful $" + amount + ". New balance: $" + balance);
    } else {
        System.out.println("Invalid Value. Please enter a Valid Value");
    }
}
    
    public void withdraw(double amount) {
    if (amount > 0) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn Succesful $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds. Current balance: $" + balance);
        }
    } else {
        System.out.println("Invalid Value. Please enter a Valid value.");
    }
}

    private boolean isValidAmount(double amount) {
        return Double.isFinite(amount) && amount >= 0;
    }

    
    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

System.out.println("//WELCOME TO TCC BANK//");
        System.out.println();
System.out.println("//Create Account//: ");
System.out.println();
        System.out.print("Enter Bank Account Name: ");
        String accountHolder = scanner.nextLine();

        System.out.print("Enter Bank initial balance: ");
        double initialBalance = scanner.nextDouble();

        Bank account = new Bank(accountHolder, initialBalance);

        int choice;
        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");
            System.out.print("Enter the number of your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    System.out.println("Exiting TCC Bank. Thankyou!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
