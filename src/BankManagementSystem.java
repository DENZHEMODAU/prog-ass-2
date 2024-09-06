import java.util.Scanner;

public class BankManagementSystem {
    
    private BankAccount[] accounts;
    
    private int accountCount;
    
    private Scanner scanner;

    
    public BankManagementSystem(int maxAccounts) {
        
        accounts = new BankAccount[maxAccounts];
        
        accountCount = 0;
        
        scanner = new Scanner(System.in);
    }

   
    public void createAccount() {
        System.out.print("Enter account holder's name: ");
        
        String name = scanner.nextLine();
        
        System.out.print("Enter account holder's email: ");
        
        String email = scanner.nextLine();
        
        System.out.print("Enter account number: ");
        
        String accountNumber = scanner.nextLine();
        
        System.out.print("Enter initial balance: ");
        
        double initialBalance = scanner.nextDouble();
        
        scanner.nextLine(); 

        accounts[accountCount] = new BankAccount(name, email, accountNumber, initialBalance);
        
        accountCount++;
        
        System.out.println("Account created successfully.");
    }

   
    public void deposit() {
        
        BankAccount account = findAccount();
        
        if (account != null) {
            
            System.out.print("Enter amount to deposit: ");
            
            double amount = scanner.nextDouble();
            
            account.deposit(amount);
        }
    }

   
    public void withdraw() {
        
        BankAccount account = findAccount();
        
        if (account != null) {
            
            System.out.print("Enter amount to withdraw: ");
            
            double amount = scanner.nextDouble();
            
            account.withdraw(amount);
        }
    }

    
    public void transfer() {
        
        System.out.println("Source Account:");
        
        BankAccount sourceAccount = findAccount();
        
        if (sourceAccount == null) return;

        System.out.println("Target Account:");
        
        BankAccount targetAccount = findAccount();
        
        if (targetAccount == null) return;

        System.out.print("Enter amount to transfer: ");
        
        double amount = scanner.nextDouble();
        
        sourceAccount.transfer(targetAccount, amount);
    }

   
    public void displayAccount() {
        
        BankAccount account = findAccount();
        
        if (account != null) {
            
            System.out.println(account);
        }
    }

    
    public void displayReport() {
        
        System.out.println("---- Bank Accounts Report ----");
        
        for (int i = 0; i < accountCount; i++) {
            
            System.out.println(accounts[i]);
        }
    }

   
    private BankAccount findAccount() {
        
        System.out.print("Enter account number: ");
        
        String accountNumber = scanner.nextLine();

        for (int i = 0; i < accountCount; i++) {
            
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                
                return accounts[i];
            }
        }

        System.out.println("Account not found.");
        
        return null;
    }

    
    public void launchMenu() {
        
        while (true) {
            
            System.out.println("Bank Management System");
            
            System.out.println("(1) Create Account");
            
            System.out.println("(2) Deposit");
            
            System.out.println("(3) Withdraw");
            
            System.out.println("(4) Transfer");
            
            System.out.println("(5) Display Account Details");
            
            System.out.println("(6) Display All Accounts Report");
            
            System.out.println("(7) Exit");

            int choice = scanner.nextInt();
            
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createAccount();
                    
                    break;
                case 2:
                    deposit();
                    
                    break;
                case 3:
                    withdraw();
                    
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    displayAccount();
                    
                    break;
                case 6:
                    displayReport();
                    
                    break;
                case 7:
                    System.out.println("Exiting system.");
                    
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        BankManagementSystem system = new BankManagementSystem(100); // Max 100 accounts
        system.launchMenu();
    }

    

}