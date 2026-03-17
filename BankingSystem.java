import java.util.HashMap;
import java.util.Scanner;

public class BankingSystem {
    private static class BankAccount {
        String accountNumber;
        String accountHolder;
        double balance;
        
        BankAccount(String accountNumber, String accountHolder, double initialBalance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
        }
    }
    
    private HashMap<String, BankAccount> accounts;
    private Scanner scanner;
    
    public BankingSystem() {
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);
    }
    
    public void createAccount(String accountNumber, String accountHolder, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
            return;
        }
        accounts.put(accountNumber, new BankAccount(accountNumber, accountHolder, initialBalance));
        System.out.println("Account created successfully!");
    }
    
    public void deposit(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }
        account.balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + account.balance);
    }
    
    public void withdraw(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        if (amount <= 0 || amount > account.balance) {
            System.out.println("Invalid amount or insufficient balance!");
            return;
        }
        account.balance -= amount;
        System.out.println("Withdrawn: " + amount + ", New Balance: " + account.balance);
    }
    
    public void checkBalance(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.println("Account Holder: " + account.accountHolder);
        System.out.println("Balance: " + account.balance);
    }
    
    public void run() {
        int choice;
        while (true) {
            System.out.println("\n=== Banking System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = scanner.nextDouble();
                    createAccount(accNum, name, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    String depAccNum = scanner.nextLine();
                    System.out.print("Enter Amount to Deposit: ");
                    double depAmount = scanner.nextDouble();
                    deposit(depAccNum, depAmount);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    String withAccNum = scanner.nextLine();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withAmount = scanner.nextDouble();
                    withdraw(withAccNum, withAmount);
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    String checkAccNum = scanner.nextLine();
                    checkBalance(checkAccNum);
                    break;
                case 5:
                    System.out.println("Thank you for using our service!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.run();
    }
}
