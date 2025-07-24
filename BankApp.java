import java.util.*;

class Account {
    String holderName;
    int accountNumber;
    double balance;

    Account(String holderName, int accountNumber) {
        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    void displayDetails() {
        System.out.println("Name: " + holderName + ", Account No: " + accountNumber + ", Balance: " + balance);
    }
}

public class BankApp {
    static List<Account> accounts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int accountCounter = 1001;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Create Account\n2. Deposit\n3. Withdraw\n4. Show Accounts\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: showAccounts(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void createAccount() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Account acc = new Account(name, accountCounter++);
        accounts.add(acc);
        System.out.println("Account created. Account No: " + acc.accountNumber);
    }

    static void deposit() {
        System.out.print("Enter account number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        for (Account acc : accounts) {
            if (acc.accountNumber == accNo) {
                acc.balance += amount;
                System.out.println("Deposited successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    static void withdraw() {
        System.out.print("Enter account number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        for (Account acc : accounts) {
            if (acc.accountNumber == accNo) {
                if (acc.balance >= amount) {
                    acc.balance -= amount;
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Insufficient balance.");
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }

    static void showAccounts() {
        for (Account acc : accounts) {
            acc.displayDetails();
        }
    }
}
