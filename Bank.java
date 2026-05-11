import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class Bank {

    private ArrayList<Account> accountsAdded = new ArrayList<>();
    public void addAccount(Account account){
        accountsAdded.add(account);
    }

    public Account findAccount(String name){
        for(Account account : accountsAdded){
            if (account.getName().equals(name)) {
                return account;
            }
        }
        return null;
    }

    public boolean hasAccounts(){
        return accountsAdded.size() > 0;
    }

    public void saveAccounts() throws IOException {
        FileWriter writer = new FileWriter("accounts.txt");
        for(Account account : accountsAdded){
            writer.write(account.getName() + "," + account.getBalance() + "," + account.getPin() + "\n");
        }
        writer.close();
    }

    public void loadAccounts() throws IOException{
        File file = new File("accounts.txt");
        if (!file.exists()) {
            return;
        }
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split(",");
             String name = parts[0];
            double balance = Double.parseDouble(parts[1]);
            int pin = Integer.parseInt(parts[2]);
            accountsAdded.add(new Account(name, balance, pin));
        }
        fileScanner.close();
    }

}
