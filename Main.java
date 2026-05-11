import java.util.Scanner;
public class Main {
      
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        boolean authenticated = false;

        System.out.println("Welcome to DanBank!");
        System.out.println("What is your account name?");
        String accountName = scanner.nextLine();
        System.out.println("What is your starting balance?");
        double accountBalance = scanner.nextDouble();
        System.out.println("Please add a four digit pin to your account!");
        int accountPin = scanner.nextInt();

        Account account1 = new Account(accountName, accountBalance, accountPin);

        while (!authenticated){
            System.out.println("Please insert PIN to access account");
            int pinInput = scanner.nextInt();  
            if(pinInput == accountPin){
                authenticated = true;
            } else {
                System.out.println("Incorrect Pin, try again");
            }
        }
        while (running){
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("5. View Transaction History");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    //Deposit
                    System.out.println("How much would you like to deposit?");
                    double depositAmount = scanner.nextDouble();
                    account1.deposit(depositAmount);
                    System.out.println("New account balance: " + account1.getBalance());
                    break;
                case 2:
                    //Withdraw
                    System.out.println("How much would you like to Withdraw?");
                    double withdrawAmount = scanner.nextDouble();
                    if(withdrawAmount < account1.getBalance()){
                        account1.withdraw(withdrawAmount);
                        System.out.println("Amount sucessfully withdrawn: " + withdrawAmount);
                        System.out.println("New account balance: " + account1.getBalance());
                    }
                    else{
                        System.out.println("Withdraw amount exceeds account amount");
                    }
                    break;
                case 3:
                    System.out.println("Balance: $" + account1.getBalance());
                    break;
                case 4:
                    running = false;
                    break;
                case 5:
                    for(String transaction : account1.getTransactionHistory()){
                        System.out.println(transaction);
                    }
                    break;
            }
        }
    }   
            
}