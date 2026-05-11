import java.util.ArrayList; 

public class Account{
    private String name;
    private double balance;
    private int pin;
    private ArrayList<String> transactionHistory;
    
    public Account(String name, double balance, int pin){
        this.name = name;
        this.balance = balance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount){
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
    }

    public void withdraw(double amount){
        if (amount > balance) {
            System.out.println("Insufficient Funds");
        }
        else{
           balance -= amount;  
           transactionHistory.add("Withdrawn: $" + amount);
        }
    }

    public String getName(){
        return name;
    }

    public double getBalance(){
        return balance;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }          
    
    public int getPin(){
        return pin;
    }
        
    }