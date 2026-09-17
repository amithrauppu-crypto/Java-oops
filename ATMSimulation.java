import java.io.*;
import java.util.*;

public class ATMSimulation {

    static double balance = 5000;
    static ArrayList<String> transactions = new ArrayList<>();

    static final String FILE = "account.txt";
    static final int PIN = 1234;

    // Load saved data
    static void loadData() {
        try {
            File file = new File(FILE);

            if (file.exists()) {
                Scanner fileReader = new Scanner(file);

                if (fileReader.hasNextLine()) {
                    balance = Double.parseDouble(fileReader.nextLine());
                }

                while (fileReader.hasNextLine()) {
                    transactions.add(fileReader.nextLine());
                }

                fileReader.close();
            }

        } catch (Exception e) {
            System.out.println("Error loading account data.");
        }
    }

    // Save data
    static void saveData() {
        try {
            PrintWriter writer = new PrintWriter(FILE);

            writer.println(balance);

            for (String transaction : transactions) {
                writer.println(transaction);
            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Error saving account data.");
        }
    }

    // Deposit
    static void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        balance += amount;
        transactions.add("Deposit: ₹" + amount);

        saveData();

        System.out.println("Deposit successful.");
    }

    // Withdraw
    static void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount.");
        }
        else if (amount > balance) {
            System.out.println("Insufficient balance.");
        }
        else {
            balance -= amount;
            transactions.add("Withdraw: ₹" + amount);

            saveData();

            System.out.println("Withdrawal successful.");
        }
    }

    // Transaction history
    static void showTransactions() {

        System.out.println("\n--- Transaction History ---");

        if (transactions.isEmpty()) {
            System.out.println("No transactions.");
        }
        else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        loadData();

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin != PIN) {
            System.out.println("Incorrect PIN.");
            return;
        }

        System.out.println("Login successful!");

        while (true) {

            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Balance: ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;

                case 4:
                    showTransactions();
                    break;

                case 5:
                    saveData();
                    System.out.println("Thank you for using ATM.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
