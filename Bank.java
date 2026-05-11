import java.util.ArrayList;

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
}
