public class BankAccount extends Person {
    
    private String accountNumber;
    
    private double balance;

   
    public BankAccount(String name, String email, String accountNumber, double initialBalance) {
        
        super(name, email);
        
        this.accountNumber = accountNumber;
        
        this.balance = initialBalance;
    }

    
    public void deposit(double amount) {
        
        balance += amount;
        
        System.out.println("Deposited " + amount + " To Account " + accountNumber);
    }

    
    public void withdraw(double amount) {
        
        if (balance >= amount) {
            
            balance -= amount;
            
            System.out.println("Withdrew " + amount + " From Account " + accountNumber);
            
        } else {
            System.out.println("Insufficient balance.");
        }
    }

   
    public void transfer(BankAccount targetAccount, double amount) {
        
        if (balance >= amount) {
            
            withdraw(amount);
            
            targetAccount.deposit(amount);
            
            System.out.println("Transferred " + amount + " from account " + accountNumber + " to account " + targetAccount.getAccountNumber());
            
        } else {
            
            System.out.println("Insufficient balance for transfer.");
        }
    }

    public double getBalance() {
        
        return balance;
    }

    public String getAccountNumber() {
        
        return accountNumber;
    }

    @Override
    public String toString() {
        
        return super.toString() + ", Account Number: " + accountNumber + ", Balance: " + balance;
    }
}
